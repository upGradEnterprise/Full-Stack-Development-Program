package com.zeta.spring.lifecycle.annotationmethod.bean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component public class TeamLead implements Employee {

    @Override public void work() {
        System.out.println("Team Lead works for Manager");
    }

    @PostConstruct public void afterPropertiesSet() throws Exception {
        System.out.println("Team Lead after PropertiesSet");
    }

    @PreDestroy public void destroy() throws Exception {
        System.out.println("Team Lead destroy");
    }

}