package com.zeta.designpatterns.singleton.eagerinitialization;

public class Singleton {

    // Eager Initialization
    private static Singleton uniqueInstance = new Singleton();

    private Singleton() { System.out.println("Singleton instance is created"); }

    // Returns the instance of the class
    public static Singleton getInstance() { return uniqueInstance; }

}
