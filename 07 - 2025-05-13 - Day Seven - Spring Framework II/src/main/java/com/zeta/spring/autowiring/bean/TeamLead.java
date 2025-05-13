package com.zeta.spring.autowiring.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component public class TeamLead implements Employee {
    @Autowired private Manager manager;

    @Autowired @Qualifier("partTimeEmployee") private Salary salary;

//    @Autowired public TeamLead(Manager manager) {
//        this.manager = manager;
//    }

//    @Autowired public void setManager(Manager manager) {
//        this.manager = manager;
//    }

    @Override public void sayHello() {
        System.out.println("Say Hello to TeamLead");
        manager.sayHello();
        salary.hoursWorked();
    }
}