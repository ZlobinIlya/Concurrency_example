package com.epam.jtc.zlobin.bank;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private int balance;
    private LongAdder faildCounter  = new LongAdder();
    private final Lock lock = new ReentrantLock();


    public int getBalance() {
        return balance;
    }

    public Long getFaildCounter() {
        return faildCounter.sum();
    }

    public void incFaildCount(){
        faildCounter.increment();
    }

    public Account(int initialBalance) {
        this.balance = initialBalance;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public Lock getLock() {

        return lock;

    }
}
