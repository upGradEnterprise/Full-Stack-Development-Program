package com.zeta.spring.autowiring.bean;

import org.springframework.stereotype.Component;

@Component public class Manager implements Employee {
    @Override public void sayHello() {
        System.out.println("Say Hello to the Manager");
    }
}
