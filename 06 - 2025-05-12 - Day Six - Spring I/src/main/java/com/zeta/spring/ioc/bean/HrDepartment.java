package com.zeta.spring.ioc.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component public class HrDepartment implements Cloneable {
    Department department = new Department();

    @Autowired public void setDepartment(Department department) {
        this.department.setName("HR");
        this.department.setLocation("Delhi");
    }

    @Override public String toString() {
        return "HrDepartment{" +
                "department=" + department +
                '}';
    }

    @Override protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}