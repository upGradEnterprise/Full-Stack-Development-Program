package com.zeta.designpatterns.singleton.lazyinitialization;

public class Singleton {

    private static Singleton uniqueInstance = null;

    private Singleton() { System.out.println("Singleton instance creating..."); }

    public static Singleton getInstance() {
        if(uniqueInstance == null) {
            synchronized(Singleton.class) {
                if(uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }

    public static void useSingleton() {
        Singleton singleton = Singleton.getInstance();
        System.out.println("Singleton instance hashCode: " + singleton.hashCode());
    }
}
