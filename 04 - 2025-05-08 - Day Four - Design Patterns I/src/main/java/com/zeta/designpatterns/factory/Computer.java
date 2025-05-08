package com.zeta.designpatterns.factory;

public abstract class Computer {
    public abstract String getCpu();
    public abstract String getMemory();
    public abstract String getStorage();

    @Override public String toString() {
        return "Computer [CPU=" + getCpu() + ", Memory=" + getMemory() + ", Storage=" + getStorage() + "]";
    }
}