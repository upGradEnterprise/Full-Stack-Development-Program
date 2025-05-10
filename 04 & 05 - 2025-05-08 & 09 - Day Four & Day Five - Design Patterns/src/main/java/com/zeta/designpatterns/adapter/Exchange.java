package com.zeta.designpatterns.adapter;

public class Exchange {
    public Currency getCurrency() { return new Currency(1); }
}