package com.zeta.designpatterns;

public class Company {
    public static void main(String[] args) {
        Employee employee1 = new Employee(1, "Dilip", 30000.0);
        Employee employee2 = new Employee(1, "Dilip", 30000.0);
        System.out.println("employee1 == employee2 : " + (employee1 == employee2));
        System.out.println("employee1.equals(employee2) : " + (employee1.equals(employee2)));
        System.out.println("employee1.hashCode() : " + (employee1.hashCode()));
        System.out.println("employee2.hashCode() : " + (employee2.hashCode()));
    }
}
