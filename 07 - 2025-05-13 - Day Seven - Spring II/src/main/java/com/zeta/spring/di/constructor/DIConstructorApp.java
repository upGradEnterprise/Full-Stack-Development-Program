package com.zeta.spring.di.constructor;

import com.zeta.spring.di.constructor.bean.Employee;
import com.zeta.spring.di.constructor.bean.TeamLead;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DIConstructorApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("diConstructorContext.xml");
        Employee teamLead = context.getBean(TeamLead.class);
        System.out.println(teamLead.getSalary(21));
    }
}