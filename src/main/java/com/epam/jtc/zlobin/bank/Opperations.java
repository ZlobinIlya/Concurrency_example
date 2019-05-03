package com.epam.jtc.zlobin.bank;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class  Opperations {

    private static final int NUM_A_B_TRANSFERS = 3;
    private static final int NUM_B_A_TRANSFERS = 4;

    static volatile long transferAbStart;
    static volatile long transferAbEnd;
    public static void main(String[] args) throws InsufficientFundsExeptions {

        final Account a = new Account(1000);
        final Account b = new Account(2000);
        String [] names = new String[]{"Павлик","Жопа","День"};
        Random rnd = new Random();

        ExecutorService service = Executors.newFixedThreadPool(3);
        for (int i = 0; i < NUM_A_B_TRANSFERS; i++) {
            service.submit(new Transfer(a, b, 200, names[i]));
        }
        service.shutdown();






  }
}
