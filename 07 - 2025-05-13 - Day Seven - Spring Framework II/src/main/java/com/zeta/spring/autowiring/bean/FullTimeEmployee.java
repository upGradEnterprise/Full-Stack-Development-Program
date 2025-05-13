package com.zeta.spring.autowiring.bean;

import org.springframework.stereotype.Component;

@Component public class FullTimeEmployee implements Salary {

    @Override public void hoursWorked() {
        System.out.println("hours worked: 8 hours");
    }

}