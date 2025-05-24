package com.zeta.endtoendtesting.service;

import com.zeta.endtoendtesting.model.Employee;
import com.zeta.endtoendtesting.repository.EmployeeRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class) @TestMethodOrder(MethodOrderer.OrderAnnotation.class) public class EmployeeServiceTest {

    @Mock private EmployeeRepository employeeRepository;

    @InjectMocks private EmployeeService employeeService;

    private Employee employee;

    @BeforeEach public void setUp() {
        employee = new Employee();
        employee.setId(1L);
        employee.setFullName("Mahesh Babu");
        employee.setSalary(100000);
    }

    @Test @DisplayName("Service Test 1: Save Employee") @Order(1) public void testSaveEmployee() {
        // pre-condition
        given(employeeRepository.save(employee)).willReturn(employee);

        // action
        Employee savedEmployee = employeeService.addEmployee(employee);

        // verify
        System.out.println(savedEmployee);
        assertThat(savedEmployee).isNotNull();
    }

    @Test @DisplayName("Service Test 2: Get All Employees") @Order(2) public void testGetAllEmployees() {
        Employee anotherEmployee = new Employee();
        anotherEmployee.setId(2L);
        anotherEmployee.setFullName("Nani");
        anotherEmployee.setSalary(50000);

        // pre-condition
        given(employeeRepository.findAll()).willReturn(List.of(employee, anotherEmployee));

        // action
        employeeService.addEmployee(employee);
        employeeService.addEmployee(anotherEmployee);
        List<Employee> allEmployees = employeeService.getAllEmployees();

        // verify
        System.out.println(allEmployees);
        assertThat(allEmployees).isNotNull();
        assertThat(allEmployees.size()).isEqualTo(2);
    }

    @Test @DisplayName("Service Test 3: Get Employee By Id") @Order(3) public void testGetEmployeeById() {
        // pre-condition
        given(employeeRepository.findById(employee.getId())).willReturn(Optional.of(employee));

        // action
        Employee existingEmployee = employeeService.getEmployeeById(employee.getId());

        // verify
        System.out.println(existingEmployee);
        assertThat(existingEmployee).isNotNull();
    }

    @Test @DisplayName("Service Test 4: Update Employee") @Order(4) public void testUpdateEmployee() {
        // pre-condition
        given(employeeRepository.findById(employee.getId())).willReturn(Optional.of(employee));
        employee.setFullName("Vijay Devarakonda");
        employee.setSalary(60000);
        given(employeeRepository.save(employee)).willReturn(employee);

        // action
        Employee updatedEmployee = employeeService.updateEmployee(employee);

        // verify
        System.out.println(updatedEmployee);
        assertThat(updatedEmployee.getFullName()).isEqualTo("Vijay Devarakonda");
        assertThat(updatedEmployee.getSalary()).isEqualTo(60000);
    }

    @Test @DisplayName("Service Test 5: Delete Employee") @Order(5) public void testDeleteEmployee() {
        // pre-condition
        given(employeeRepository.findById(employee.getId())).willReturn(Optional.of(employee));

        // action
        employeeService.deleteEmployee(employee.getId());

        // verify
        verify(employeeRepository).delete(employee);
    }
}