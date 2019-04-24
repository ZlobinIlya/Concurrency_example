package com.epam.jtc.zlobin.bank;

public class Opperations {
    public static void main(String[] args) throws InsufficientFundsExeptions {

        final Account a = new Account(1000);
        final Account b = new Account(2000);
        Process process1 = new Process(a,b,500, "Первый");
        Process1 process2 = new Process1(a,b,300, "Второй");


        process1.start();
        process2.start();


//        new Thread(new Runnable() {
//            @Override public void run() {
//
//                try {
//                    transfer(a, b, 500);
//                } catch (InsufficientFundsExeptions insufficientFundsExeptions) {
//                    insufficientFundsExeptions.printStackTrace();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override public void run() {
//                try {
//                    transfer(b, a, 300);
//                } catch (InsufficientFundsExeptions insufficientFundsExeptions) {
//                    insufficientFundsExeptions.printStackTrace();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }).start();
//
//    }
//
//    public static void transfer(Account a, Account b, int i)
//            throws InsufficientFundsExeptions, InterruptedException {
//        if (a.getBalance() < i) throw new InsufficientFundsExeptions();
//        synchronized (a) {
//            System.out.println("Засинхронился - А");
//            Thread.sleep(1000);
//            synchronized (b) {
//                System.out.println("Засинхронился - Б");
//                a.withdraw(i);
//                b.deposit(i);
//                System.out.println("Трансфер выполнился");
//            }
//        }
//
//
  }
}
