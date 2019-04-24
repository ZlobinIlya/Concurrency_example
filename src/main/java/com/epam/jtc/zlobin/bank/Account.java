package com.epam.jtc.zlobin.bank;

public class Account {
    private int balance;

    public int getBalance() {
        return balance;
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
}
