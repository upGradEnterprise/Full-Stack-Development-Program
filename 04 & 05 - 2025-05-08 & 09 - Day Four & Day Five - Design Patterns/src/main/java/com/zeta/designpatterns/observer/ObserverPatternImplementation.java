package com.zeta.designpatterns.observer;

public class ObserverPatternImplementation {
    public static void main(String[] args) {

        WeatherStation weatherStation = new WeatherStation();

        Device phone = new Device("Mobile Phone");
        Device tablet = new Device("Tablet");
        Device desktop = new Device("Desktop");

        weatherStation.addObserver(phone);
        weatherStation.addObserver(tablet);
        weatherStation.addObserver(desktop);

        System.out.println("Change in temperature : ");
        weatherStation.setTemperature(20.0);
        System.out.println();

        System.out.println("Change in temperature(without phone as observer) : ");
        weatherStation.removeObserver(phone);
        weatherStation.setTemperature(30.0);

    }
}