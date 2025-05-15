package com.zeta.designpatterns.builder;

public class BuilderPatternTest {
    public static void main(String[] args) {
        Computer computer = new Computer.ComputerBuilder("Intel", "256GB", "2TB")
                .setGpuEnabled(true)
                .setBluetoothEnabled(true)
                .build();

        System.out.println(computer);
    }
}