package com.epam.jtc.zlobin.bank;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private int balance;
    private int faildCounter;
    private final Lock lock = new ReentrantLock();


    public int getBalance() {
        return balance;
    }

    public int getFaildCounter() {
        return faildCounter;
    }

    public void incFaildCount(){
        faildCounter++;
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
