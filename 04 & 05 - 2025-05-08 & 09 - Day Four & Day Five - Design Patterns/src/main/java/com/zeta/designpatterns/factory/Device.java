package com.zeta.designpatterns.factory;

public class Device {
    public static void main(String[] args) {
        Computer desktop = ComputerFactory.getComputer("desktop", "AMD", "512GB", "2TB");
        Computer laptop  = ComputerFactory.getComputer("laptop", "Intel", "8GB", "1TB");
        System.out.println(desktop);
        Desktop desktopComputer = (Desktop) desktop;
        System.out.println("Computer Name: " + desktopComputer.getName());
        System.out.println(laptop);
    }
}