package com.zeta.designpatterns.decorator;

public class AllCars {
    public static void main(String[] args) {
        Car car;

        car = new BasicCar();
        System.out.println("Assembling Basic Car");
        car.assemble();
        System.out.println();

        car = new SportsCar(new BasicCar());
        System.out.println("Assembling Sports Car");
        car.assemble();
        System.out.println();

        car = new LuxuryCar(new SportsCar(new BasicCar()));
        System.out.println("Assembling Luxury Car");
        car.assemble();
        System.out.println();
    }
}
