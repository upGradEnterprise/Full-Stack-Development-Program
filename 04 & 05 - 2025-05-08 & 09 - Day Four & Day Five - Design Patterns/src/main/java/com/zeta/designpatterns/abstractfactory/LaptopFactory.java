package com.zeta.designpatterns.abstractfactory;

public class LaptopFactory implements AbstractComputerFactory {
    private String cpu;
    private String memory;
    private String storage;

    public LaptopFactory(String cpu, String memory, String storage) {
        this.cpu = cpu;
        this.memory = memory;
        this.storage = storage;
    }

    @Override public Computer createComputer() { return new Laptop(cpu, memory, storage); }
}