package com.zeta.spring.di.setter.bean;

import org.springframework.stereotype.Component;

@Component public class TeamLead implements Employee {
    private double salary;
    private Manager manager;

    public TeamLead(double salary) {
        System.out.println("Setting Salary to Team Lead");
        this.salary = salary;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    @Override public double getSalary(int daysWorked) {
        return (manager.getSalary(daysWorked) / 30) * daysWorked;
    }
}