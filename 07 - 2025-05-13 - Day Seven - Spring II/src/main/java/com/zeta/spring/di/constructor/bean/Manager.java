package com.zeta.spring.di.constructor.bean;

import org.springframework.stereotype.Component;

@Component public class Manager implements Employee {
    private double salary;

    public Manager(double salary) {
        System.out.println("Setting Salary to Manager");
        this.salary = salary;
    }

    @Override public double getSalary(int daysWorked) {
        return (salary / 30) * daysWorked;
    }
}