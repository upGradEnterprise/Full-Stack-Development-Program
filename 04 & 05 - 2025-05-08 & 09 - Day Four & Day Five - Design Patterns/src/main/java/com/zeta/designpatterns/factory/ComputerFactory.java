package com.zeta.designpatterns.factory;

public class ComputerFactory {
    public static Computer getComputer(String computerType, String cpu, String memory, String storage) {
        return  computerType.equals("desktop") ? new Desktop(cpu, memory, storage) :
                computerType.equals("laptop") ? new Laptop(cpu, memory, storage) : null;
    }
}
