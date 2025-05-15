package com.zeta.spring.ioc.bean;

import org.springframework.stereotype.Component;

@Component public class Department {
    private String name;
    private String location;

    public void setName(String name) { this.name = name; }
    public void setLocation(String location) { this.location = location; }

    @Override public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}