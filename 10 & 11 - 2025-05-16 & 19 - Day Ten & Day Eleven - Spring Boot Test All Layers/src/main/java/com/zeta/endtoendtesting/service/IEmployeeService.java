package com.zeta.endtoendtesting.service;

import com.zeta.endtoendtesting.model.Employee;

import java.util.List;

public interface IEmployeeService {
    Employee addEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(long id);
    Employee updateEmployee(Employee employee);
    void deleteEmployee(long id);
}