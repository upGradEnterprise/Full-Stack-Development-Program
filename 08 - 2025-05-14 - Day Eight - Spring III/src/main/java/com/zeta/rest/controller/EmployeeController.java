package com.zeta.rest.controller;

import com.zeta.rest.exception.ResourceNotFoundException;
import com.zeta.rest.model.Employee;
import com.zeta.rest.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController @RequestMapping("/api/employees") public class EmployeeController {
    @Autowired public EmployeeRepository repository;

    @GetMapping public ResponseEntity<List<Employee>> findAll() {
        List<Employee> employees = repository.findAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/{id}") public ResponseEntity<Employee> findById(@PathVariable Long id) {
        Employee employee = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id " + id));
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        Employee newEmployee = repository.save(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping public ResponseEntity<Employee> update(@RequestBody Employee employee) {
        Employee updatedEmployee = repository.save(employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/{id}") public ResponseEntity<Employee> delete(@PathVariable Long id) {
        Employee employee = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id " + id));
        repository.delete(employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}