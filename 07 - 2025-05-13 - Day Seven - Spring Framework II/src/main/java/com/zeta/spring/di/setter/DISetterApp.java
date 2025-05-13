package com.zeta.spring.di.setter;

import com.zeta.spring.di.setter.bean.Employee;
import com.zeta.spring.di.setter.bean.TeamLead;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DISetterApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("diSetterContext.xml");
        Employee teamLead = context.getBean(TeamLead.class);
        System.out.println(teamLead.getSalary(21));
    }
}