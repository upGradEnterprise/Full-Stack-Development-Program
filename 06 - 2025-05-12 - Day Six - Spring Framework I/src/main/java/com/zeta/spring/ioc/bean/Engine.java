package com.zeta.spring.ioc.bean;

import org.springframework.stereotype.Component;

@Component public class Engine {
    private String engineType;

    public String getEngineType() { return engineType; }

    public void setEngineType(String engineType) { this.engineType = engineType; }
}