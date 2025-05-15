package com.zeta.designpatterns.observer;

import java.util.List;

public abstract class Subject {
    protected List<Device> devices;
    protected double temperature;

    public abstract void addObserver(Device observer);

    public abstract void removeObserver(Device observer);

    public abstract void setTemperature(double temperature);

    public abstract double getTemperature ();

    public abstract void notifyDevices ();
}
