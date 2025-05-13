package com.zeta.spring.lifecycle.annotationmethod;

import com.zeta.spring.lifecycle.annotationmethod.bean.Employee;
import com.zeta.spring.lifecycle.annotationmethod.bean.Manager;
import com.zeta.spring.lifecycle.annotationmethod.bean.TeamLead;
import com.zeta.spring.lifecycle.annotationmethod.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LifeCycleAnnotationApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Employee manager = context.getBean(Manager.class);
        Employee teamLead = context.getBean(TeamLead.class);
        manager.work();
        teamLead.work();
        context.close();
    }
}