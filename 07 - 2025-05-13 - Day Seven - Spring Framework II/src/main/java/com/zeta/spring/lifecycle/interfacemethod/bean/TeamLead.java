package com.zeta.spring.lifecycle.interfacemethod.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component public class TeamLead implements InitializingBean, DisposableBean, Employee {

    @Override public void work() {
        System.out.println("Team Lead works for Manager");
    }

    @Override public void afterPropertiesSet() throws Exception {
        System.out.println("Team Lead after PropertiesSet");
    }

    @Override public void destroy() throws Exception {
        System.out.println("Team Lead destroy");
    }

}