package com.zeta.designpatterns.prototype;

public class Employee {
    private long id;
    private String name;
    private double salary;

    public Employee(long id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Employee(Employee employee) {
        this.id = employee.id;
        this.name = employee.name;
        this.salary = employee.salary;
    }

    public void setName(String name) { this.name = name; }

    @Override public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
    }
}
