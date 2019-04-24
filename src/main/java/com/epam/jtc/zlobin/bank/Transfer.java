package com.epam.jtc.zlobin.bank;

import com.sun.org.apache.xalan.internal.xsltc.dom.CollatorFactoryBase;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Transfer implements Callable<Boolean> {
    private static final int LOCK_WAIT_SEC = 5;
    private static final int MAX_TRANSFER_SEC = 7;
    private final Random waitRandom = new Random();
    Account a;
    Account b;
    int i;
    int id;

    public int getId() {
        return id;
    }

    public Transfer(Account a, Account b, int i) {
        this.a = a;
        this.b = b;
        this.i = i;
    }

    @Override public Boolean call() throws Exception {
        if (a.getLock().tryLock(LOCK_WAIT_SEC, TimeUnit.SECONDS)) {
            try {
                if (a.getBalance() < i) {
                    a.incFaildCount();
                }
                if (b.getLock().tryLock(LOCK_WAIT_SEC, TimeUnit.SECONDS)) {
                    try {
                        a.withdraw(i);
                        b.deposit(i);
                        Thread.sleep(
                                waitRandom.nextInt(MAX_TRANSFER_SEC * 1000));

                        return true;
                    } finally {
                        b.getLock().unlock();
                    }
                } else {
                    b.incFaildCount();
                    return false;
                }
            } finally {
                a.getLock().unlock();
            }
        } else {
            a.incFaildCount();
            return false;
        }
    }
}

