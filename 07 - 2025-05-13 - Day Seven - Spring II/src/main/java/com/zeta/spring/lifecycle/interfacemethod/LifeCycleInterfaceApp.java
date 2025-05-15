package com.zeta.spring.lifecycle.interfacemethod;

import com.zeta.spring.lifecycle.interfacemethod.bean.Employee;
import com.zeta.spring.lifecycle.interfacemethod.bean.Manager;
import com.zeta.spring.lifecycle.interfacemethod.bean.TeamLead;
import com.zeta.spring.lifecycle.interfacemethod.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LifeCycleInterfaceApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Employee manager = context.getBean(Manager.class);
        Employee teamLead = context.getBean(TeamLead.class);

        manager.work();
        teamLead.work();

        context.close();
    }
}
