package com.zeta.designpatterns.prototype;

import java.util.ArrayList;
import java.util.List;

public class Employees implements Cloneable {

    private List<Employee> employees;

    public Employees(){ employees = new ArrayList<Employee>(); }
    public Employees(List<Employee> employees) { this.employees = employees; }

    public void addEmployee(Employee employee){ employees.add(employee); }
    public List<Employee> getEmployees() { return employees; }

    @Override public Object clone() throws CloneNotSupportedException {
        List<Employee> tempEmployees = new ArrayList<Employee>();
        for (Employee employee : employees) {
            tempEmployees.add(new Employee(employee));
        }
        return new Employees(tempEmployees);
    }

}
