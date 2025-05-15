package com.zeta.spring.lifecycle.annotationmethod.bean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component public class Manager implements Employee {

    @Override public void work() {
        System.out.println("Manager Works for Director");
    }

    @PostConstruct public void afterPropertiesSet() throws Exception {
        System.out.println("Manager After PropertiesSet");
    }

    @PreDestroy public void destroy() throws Exception {
        System.out.println("Manager Destroy");
    }

}