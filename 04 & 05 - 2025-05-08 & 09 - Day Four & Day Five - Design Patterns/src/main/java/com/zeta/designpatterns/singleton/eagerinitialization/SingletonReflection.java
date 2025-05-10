package com.zeta.designpatterns.singleton.eagerinitialization;

public class SingletonReflection implements Cloneable {
    private static SingletonReflection reflectionInstance = new SingletonReflection();

    private SingletonReflection() {
        System.out.println("SingletonReflection instance getting created...");
        if(reflectionInstance != null) {
            throw new RuntimeException("Can't Create SingletonReflection instance");
        }
        System.out.println("SingletonReflection instance created!");
    }

    public static SingletonReflection getInstance() { return reflectionInstance; }

    @Override public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Clone not supported");
    }
}
