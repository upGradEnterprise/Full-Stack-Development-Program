package com.zeta.spring.lifecycle.interfacemethod.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component public class Manager implements InitializingBean, DisposableBean, Employee {

    @Override public void work() {
        System.out.println("Manager Works for Director");
    }

    @Override public void afterPropertiesSet() throws Exception {
        System.out.println("Manager After PropertiesSet");
    }

    @Override public void destroy() throws Exception {
        System.out.println("Manager Destroy");
    }

}