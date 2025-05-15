package com.zeta.spring.ioc.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component public class Car {
    private Engine engine;

    @Autowired public void setEngine(Engine engine) {
        this.engine = engine;
        engine.setEngineType("mStallion");
    }

    public String getEngineType() { return this.engine.getEngineType(); }
}