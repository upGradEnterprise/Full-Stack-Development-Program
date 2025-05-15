package com.zeta.spring.ioc.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component public class SupportDepartment implements Cloneable{
    Department department = new Department();

    @Autowired public void setDepartment(Department department) {
        this.department.setName("Support");
        this.department.setLocation("Hyderabad");
    }

    @Override public String toString() {
        return "SupportDepartment{" +
                "department=" + department +
                '}';
    }

    @Override protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}