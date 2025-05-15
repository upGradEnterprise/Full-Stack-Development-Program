package com.zeta.spring.autowiring.bean;

import org.springframework.stereotype.Component;

@Component public class PartTimeEmployee implements Salary {

    @Override public void hoursWorked() {
        System.out.println("hours worked: 4 hours");
    }

}