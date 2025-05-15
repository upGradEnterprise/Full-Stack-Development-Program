package com.zeta.spring.ioc.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component public class CtoDepartment implements Cloneable {
    Department department = new Department();

    @Autowired public void setDepartment(Department department) {
        this.department.setName("CTO");
        this.department.setLocation("Bengaluru");
    }

    @Override public String toString() {
        return "CtoDepartment{" +
                "department=" + department +
                '}';
    }

    @Override protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}