package com.zeta.spring.di.constructor.bean;

import org.springframework.stereotype.Component;

@Component public class TeamLead implements Employee {
    private double salary;
    private Manager manager;

    public TeamLead(double salary, Manager manager) {
        System.out.println("Setting Salary to Team Lead");
        this.salary = salary;
        this.manager = manager;
        System.out.println("Manager set for Team Lead");
    }

    @Override public double getSalary(int daysWorked) {
        return (manager.getSalary(daysWorked) / 30) * daysWorked;
    }
}