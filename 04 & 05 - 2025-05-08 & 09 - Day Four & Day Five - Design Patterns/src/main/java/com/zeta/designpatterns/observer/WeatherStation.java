package com.zeta.designpatterns.observer;

import java.util.ArrayList;

public class WeatherStation extends Subject{

    public WeatherStation () {
        devices = new ArrayList<Device>();
    }

    public void addObserver(Device observer) {
        devices.add(observer);
    }

    public void removeObserver(Device observer) {
        devices.remove(observer);
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
        notifyDevices();
    }

    public double getTemperature () {
        return temperature;
    }

    public void notifyDevices () {
        for(Device observer : devices) {
            observer.update(temperature);
        }
    }
}