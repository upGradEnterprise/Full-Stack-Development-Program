package com.zeta.endtoendtesting.service;

import com.zeta.endtoendtesting.model.Employee;
import com.zeta.endtoendtesting.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service public class EmployeeService implements IEmployeeService {

    private final EmployeeRepository employeeRepository;
    @Autowired public EmployeeService(EmployeeRepository employeeRepository) { this.employeeRepository = employeeRepository; }

    @Override public Employee addEmployee(Employee employee) {
        Optional<Employee> employeeOptional = employeeRepository.findById(employee.getId());
        if (employeeOptional.isPresent()) { throw new RuntimeException("Employee already exists"); }
        return employeeRepository.save(employee);
    }

    @Override public List<Employee> getAllEmployees() { return employeeRepository.findAll(); }

    @Override public Employee getEmployeeById(long id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isEmpty()) { throw new RuntimeException("Employee does not exist"); }
        return employeeOptional.get();
    }

    @Override public Employee updateEmployee(Employee employee) {
        Optional<Employee> employeeOptional = employeeRepository.findById(employee.getId());
        if (employeeOptional.isEmpty()) { throw new RuntimeException("Employee does not exist"); }
        employeeOptional.get().setFullName(employee.getFullName());
        employeeOptional.get().setSalary(employee.getSalary());
        return employeeRepository.save(employeeOptional.get());
    }

    @Override public void deleteEmployee(long id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isEmpty()) { throw new RuntimeException("Employee does not exist"); }
        employeeRepository.delete(employeeOptional.get());
    }
}