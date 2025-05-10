package com.zeta.designpatterns.adapter;

public interface ExchangeAdapter {

    public Currency getDollarCurrency(Currency currency);
    public Currency getDhiramCurrency(Currency currency);
    public Currency getPoundCurrency(Currency currency);

}