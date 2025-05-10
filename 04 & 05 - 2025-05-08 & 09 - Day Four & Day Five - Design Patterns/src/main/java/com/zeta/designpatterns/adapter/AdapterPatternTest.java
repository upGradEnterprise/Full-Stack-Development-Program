package com.zeta.designpatterns.adapter;

public class AdapterPatternTest {
    public static void main(String[] args) {

        // Class Implementation of Adapter Pattern
        Currency rupees = new Currency(1000);
        System.out.println("Rupees: " + rupees.getValue());
        ExchangeAdapter exchange = new ExchangeAdapterClassImpl();
        Currency dollar = exchange.getDollarCurrency(rupees);
        System.out.println("Dollar: " + dollar.getValue());
        Currency dhirams = exchange.getDhiramCurrency(rupees);
        System.out.println("Dhirams: " + dhirams.getValue());
        Currency pounds = exchange.getPoundCurrency(rupees);
        System.out.println("Pounds: " + pounds.getValue());
    }
}