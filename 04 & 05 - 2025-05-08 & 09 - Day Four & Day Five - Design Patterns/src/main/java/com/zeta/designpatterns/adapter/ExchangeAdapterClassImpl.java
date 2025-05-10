package com.zeta.designpatterns.adapter;

public class ExchangeAdapterClassImpl extends Exchange implements ExchangeAdapter {

    @Override public Currency getDollarCurrency(Currency currency) {
        return new Currency(currency.getValue()/85);
    }

    @Override public Currency getDhiramCurrency(Currency currency) {
        return new Currency(currency.getValue()/23);
    }

    @Override public Currency getPoundCurrency(Currency currency) {
        return new Currency(currency.getValue()/113);
    }

}