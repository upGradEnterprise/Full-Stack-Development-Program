package com.zeta.designpatterns.builder;

public class Computer {

    // required parameters
    private String cpu;
    private String memory;
    private String storage;

    // optional parameters
    private boolean isGpuEnabled;
    private boolean isBluetoothEnabled;

    public String getCpu() { return cpu; }
    public String getMemory() { return memory; }
    public String getStorage() { return storage; }
    public boolean isGpuEnabled() { return isGpuEnabled; }
    public boolean isBluetoothEnabled() { return isBluetoothEnabled; }

    private Computer(ComputerBuilder builder) {
        this.cpu = builder.cpu;
        this.memory = builder.memory;
        this.storage = builder.storage;
        this.isGpuEnabled = builder.isGpuEnabled;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
    }

    @Override public String toString() {
        return "Computer [cpu=" + getCpu() + ", memory=" + getMemory() + ", storage=" + getStorage()
                + ", isGpuEnabled=" + isGpuEnabled() + ", isBluetoothEnabled=" + isBluetoothEnabled() + "]";
    }

    // Builder class
    public static class ComputerBuilder {
        // required parameters
        private String cpu;
        private String memory;
        private String storage;

        // optional parameters
        private boolean isGpuEnabled;
        private boolean isBluetoothEnabled;

        public ComputerBuilder(String cpu, String memory, String storage) {
            this.cpu = cpu;
            this.memory = memory;
            this.storage = storage;
        }

        public ComputerBuilder setGpuEnabled(boolean isGpuEnabled) {
            this.isGpuEnabled = isGpuEnabled;
            return this;
        }

        public ComputerBuilder setBluetoothEnabled(boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}