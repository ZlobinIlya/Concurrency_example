package com.epam.jtc.zlobin.bank;

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
    String name;
    public int getId() {
        return id;
    }

    public Transfer(Account a, Account b, int i , String name )  {
        this.name = name;
        this.a = a;
        this.b = b;
        this.i = i;

    }

    @Override public Boolean call() throws Exception {
        System.out.println("Поток " +name+" создан!");
        if (a.getLock().tryLock(LOCK_WAIT_SEC, TimeUnit.SECONDS)) {
            try {
                if (a.getBalance() < i) {
                    a.incFaildCount();
                    System.out.println("FFF");
                    throw new IllegalStateException("Insufficient funds in Account " );
                }
                if (b.getLock().tryLock(LOCK_WAIT_SEC, TimeUnit.SECONDS)) {
                    try {
                        System.out.println("Захватил  " + name);
                        a.withdraw(i);
                        b.deposit(i);
//                        Thread.sleep(
//                                waitRandom.nextInt(MAX_TRANSFER_SEC * 1000));
                        System.out.println("Трансфер выполнился баланс A = " + a.getBalance() + "Баланс Б = " + b.getBalance()+""+ name);

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

