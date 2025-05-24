package com.zeta.endtoendtesting.controller;

import com.zeta.endtoendtesting.model.Employee;
import com.zeta.endtoendtesting.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController@RequestMapping("/api/employees") public class EmployeeController {

    private final EmployeeService employeeService;
    @Autowired public EmployeeController(EmployeeService employeeService) { this.employeeService = employeeService; }

    @PostMapping public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) { return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.CREATED); }

    @GetMapping public ResponseEntity<List<Employee>> getAllEmployees() { return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK); }

    @GetMapping("/{id}") public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) { return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.FOUND); }

    @PutMapping public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) { return new ResponseEntity<>(employeeService.updateEmployee(employee), HttpStatus.OK); }

    @DeleteMapping("/{id}") public ResponseEntity<String> deleteEmployee(@PathVariable long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Employee Removed", HttpStatus.OK);
    }

}