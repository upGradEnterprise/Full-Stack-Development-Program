package com.zeta.designpatterns.factory;

public class Desktop extends Computer {
    private String cpu;
    private String memory;
    private String storage;

    public Desktop(String cpu, String memory, String storage) {
        this.cpu = cpu;
        this.memory = memory;
        this.storage = storage;
    }

    @Override public String getCpu() { return this.cpu; }

    @Override public String getMemory() { return this.memory; }

    @Override public String getStorage() { return this.storage; }

    public String getName() { return "Desktop"; }
}
