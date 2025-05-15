package com.zeta.designpatterns.observer;

public class Device implements IDevice {

    private final String name;

    public Device(String name) {
        this.name = name;
    }

    public String getName () { return name; }

    @Override public void update(double temperature) {
        System.out.println("Device " + name + " received temperature " + temperature);
    }

}