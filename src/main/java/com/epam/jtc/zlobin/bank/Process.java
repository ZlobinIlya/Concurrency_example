package com.epam.jtc.zlobin.bank;

public class Process extends Thread {
     Account b = null;
     Account a = null;
    int i;
    String name;

    public Process( Account b, Account a, int i, String name) {
        this.b = b;
        this.a = a;
        this.i = i;
        this.name = name;

    }

    @Override public void run() {
        try {
            transfer(b, a, i,  name);
        } catch (InsufficientFundsExeptions insufficientFundsExeptions) {
            insufficientFundsExeptions.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void transfer(Account a, Account b, int i, String name)
            throws InsufficientFundsExeptions, InterruptedException {
        if (a.getBalance() < i) throw new InsufficientFundsExeptions();
        synchronized (a) {
            System.out.println("Засинхронил - A  " + name );

            synchronized (b) {
                System.out.println("Засинхронил - Б  " + name);
                a.withdraw(i);
                b.deposit(i);
                System.out.println("Трансфер выполнился баланс A = " + a.getBalance() + "Баланс Б =" + b.getBalance());
            }
        }


    }
}
