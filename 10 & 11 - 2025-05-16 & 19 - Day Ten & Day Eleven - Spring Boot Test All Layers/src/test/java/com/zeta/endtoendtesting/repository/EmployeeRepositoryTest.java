package com.zeta.endtoendtesting.repository;

import com.zeta.endtoendtesting.model.Employee;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest @TestMethodOrder(MethodOrderer.OrderAnnotation.class) public class EmployeeRepositoryTest {

    private final EmployeeRepository employeeRepository;
    @Autowired public EmployeeRepositoryTest(EmployeeRepository employeeRepository) { this.employeeRepository = employeeRepository; }

    public Employee employee;

    @BeforeEach public void setUp() {
        employee = new Employee();
        employee.setFullName("Hrithik Roshan");
        employee.setSalary(50000.0);
    }

    @Test @DisplayName("Repository Test 1: Save Employee Test") @Order(1) public void saveEmployeeTest() {
        // Action
        Employee newEmployee = employeeRepository.save(employee);

        // Verify
        System.out.println(newEmployee);
        assertThat(newEmployee.getId()).isGreaterThan(0);
    }

    @Test @DisplayName("Repository Test 2: Get List of Employee List") @Order(2) public void getEmployeeListTest() {
        // Action
        employeeRepository.save(employee);
        List<Employee> employeeList = employeeRepository.findAll();

        // Verify
        System.out.println(employeeList);
        // assertThat(employeeList).isNotNull();
        assertThat(employeeList).isNotEmpty();
        // assertThat(employeeList.size()).isGreaterThan(0);
    }

    @Test @DisplayName("Repository Test 3: Find Employee Test") @Order(3) public void findEmployeeTest() {
        // Action
        employeeRepository.save(employee);
        Optional<Employee> fetchedEmployee = employeeRepository.findById(employee.getId());

        // Verify
        System.out.println(fetchedEmployee);
        assertTrue(fetchedEmployee.isPresent());

        Employee foundEmployee = fetchedEmployee.get();
        assertEquals("Hrithik Roshan", foundEmployee.getFullName());
        assertEquals(50000.0, foundEmployee.getSalary());
    }

    @Test @DisplayName("Repository Test 4: Update Employee Test") @Order(4) public void updateEmployeeTest() {
        // Action
        employeeRepository.save(employee);

        employee.setFullName("Shahrukh Khan");
        employee.setSalary(100000.0);
        Employee updatedEmployee = employeeRepository.save(employee);

        // Verify
        System.out.println(updatedEmployee);
        assertEquals("Shahrukh Khan", updatedEmployee.getFullName());
        assertEquals(100000.0, updatedEmployee.getSalary());
    }

    @Test @DisplayName("Repository Test 5: Delete Employee Test") @Order(5) public void deleteEmployeeTest() {
        // Action
        employeeRepository.save(employee);
        employeeRepository.delete(employee);

        // Verify
        Optional<Employee> fetchedEmployee = employeeRepository.findById(employee.getId());
        assertTrue(fetchedEmployee.isEmpty());
    }

}