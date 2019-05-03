package com.epam.jtc.zlobin.executor_service__callable.future;

import java.util.ArrayDeque;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class BaseCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        String product = ProductList.getProduct();
        String result = null;
        if (product != null) {
            result = product + " done";
        } else {
            result = "productList is empty";
        }
        TimeUnit.MILLISECONDS.sleep(100);
       System.out.println(result);
        return result;
    }
}

