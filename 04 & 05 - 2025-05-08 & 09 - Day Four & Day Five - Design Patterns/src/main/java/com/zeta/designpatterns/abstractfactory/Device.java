package com.zeta.designpatterns.abstractfactory;

public class Device {
    public static void main(String[] args) {
        Computer desktop = ComputerFactory.getComputer(new DesktopFactory("AMD", "512GB", "2TB"));
        Computer laptop  = ComputerFactory.getComputer(new LaptopFactory("Intel", "8GB", "1TB"));
        System.out.println(desktop);
        System.out.println(laptop);
    }
}