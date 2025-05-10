package com.zeta.designpatterns.singleton.lazyinitialization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonPatternTest {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(Singleton :: useSingleton);
        executorService.submit(Singleton :: useSingleton);
        executorService.shutdown();

        Singleton singletonObject01 = Singleton.getInstance();
        Singleton singletonObject02 = Singleton.getInstance();
        System.out.println("singletonObject01 hashCode : " + singletonObject01.hashCode());
        System.out.println("singletonObject02 hashCode : " + singletonObject02.hashCode());
    }
}
