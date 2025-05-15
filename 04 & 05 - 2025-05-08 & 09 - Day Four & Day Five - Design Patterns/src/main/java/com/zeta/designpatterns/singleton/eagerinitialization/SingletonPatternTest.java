package com.zeta.designpatterns.singleton.eagerinitialization;

public class SingletonPatternTest {
    public static void main(String[] args) throws Exception {
        SingletonReflection singletonReflection01 = SingletonReflection.getInstance();
        SingletonReflection singletonReflection02 = (SingletonReflection) singletonReflection01.clone();

//        Singleton singleton01 = Singleton.getInstance();
//        SingletonReflection singletonReflection02 = SingletonReflection.getInstance();
//        Singleton singleton02 = Singleton.getInstance();

        System.out.println("singletonReflection01 hashCode: " + singletonReflection01.hashCode());
        System.out.println("singletonReflection02 hashCode: " + singletonReflection02.hashCode());

//        System.out.println("singleton01 hashCode: " + singleton01.hashCode());
//        System.out.println("singleton02 hashCode: " + singleton02.hashCode());

        // faking singleton
//        Class newSingletonReflectionClass = Class.forName("com.zeta.designpatterns.singleton.SingletonReflection");
//        Constructor<SingletonReflection> newSingletonReflectionConstructor = newSingletonReflectionClass.getDeclaredConstructor();
//        newSingletonReflectionConstructor.setAccessible(true);
//
//        SingletonReflection newSingletonReflectionObject01 = newSingletonReflectionConstructor.newInstance();
//        System.out.println("newSingletonReflectionObject01 hashCode: " + newSingletonReflectionObject01.hashCode());
//
//        SingletonReflection newSingletonReflectionObject02 = newSingletonReflectionConstructor.newInstance();
//        System.out.println("newSingletonReflectionObject02 hashCode: " + newSingletonReflectionObject02.hashCode());
    }
}
