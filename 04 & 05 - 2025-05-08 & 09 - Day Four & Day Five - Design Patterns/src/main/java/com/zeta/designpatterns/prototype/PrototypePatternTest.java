package com.zeta.designpatterns.prototype;

import java.util.List;

public class PrototypePatternTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Employees employees = new Employees();
        Employee employee01 = new Employee(1, "Dilip", 50000.0);
        Employee employee02 = new Employee(2, "Raj", 30000.0);
        Employee employee03 = new Employee(3, "Rahul", 25000.0);
        employees.addEmployee(employee01);
        employees.addEmployee(employee02);
        employees.addEmployee(employee03);
        Employees newList01 = (Employees) employees.clone();
        Employees newList02 = (Employees) employees.clone();
        List<Employee> list01 = newList01.getEmployees();
        List<Employee> list02 = newList02.getEmployees();
        Employee employee04 = new Employee(4, "Kiran", 70000.0);
        list01.add(employee04);
        Employee employee05 = new Employee(5, "Gopal", 100000.0);
        list02.add(employee05);
        list01.remove(list01.get(0));
        list02.remove(list02.get(1));
        employee04.setName("Ashok");
        System.out.println("List 1: " + list01);
        System.out.println("List 2: " + list02);
        System.out.println("Original List: " + employees.getEmployees());
    }
}