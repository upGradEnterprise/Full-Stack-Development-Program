package com.zeta.designpatterns.abstractfactory;

public class DesktopFactory implements AbstractComputerFactory {
    private String cpu;
    private String memory;
    private String storage;

    public DesktopFactory(String cpu, String memory, String storage) {
        this.cpu = cpu;
        this.memory = memory;
        this.storage = storage;
    }

    @Override public Computer createComputer() { return new Desktop(cpu, memory, storage); }
}