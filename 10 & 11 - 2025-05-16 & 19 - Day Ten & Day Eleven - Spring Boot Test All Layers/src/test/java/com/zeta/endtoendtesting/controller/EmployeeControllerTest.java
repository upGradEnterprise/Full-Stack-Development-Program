package com.zeta.endtoendtesting.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zeta.endtoendtesting.model.Employee;
import com.zeta.endtoendtesting.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeController.class) public class EmployeeControllerTest {

    @Autowired private MockMvc mockMvc;

    @MockBean private EmployeeService employeeService;

    private Employee employee;

    @BeforeEach public void setUp() {
        employee = new Employee();
        employee.setId(1L);
        employee.setFullName("Prabhas");
        employee.setSalary(60000);
    }

    @Test @DisplayName("Controller Test 1: Post Employee") void shouldCreateEmployee() throws Exception {
        when(employeeService.addEmployee(any(Employee.class))).thenReturn(employee);

        String json = new ObjectMapper().writeValueAsString(employee);

        mockMvc.perform(post("/api/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.fullName").value("Prabhas"))
                .andExpect(jsonPath("$.salary").value(60000));

        verify(employeeService, times(1)).addEmployee(any(Employee.class));
    }

    @Test @DisplayName("Controller Test 2: Get All Employees") void shouldGetAllEmployees() throws Exception {
        Employee anotherEmployee = new Employee();
        anotherEmployee.setId(2L);
        anotherEmployee.setFullName("Rajinikanth");
        anotherEmployee.setSalary(500000);

        List<Employee> employees = Arrays.asList(employee, anotherEmployee);

        when(employeeService.getAllEmployees()).thenReturn(employees);

        mockMvc.perform(get("/api/employees")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2));

        verify(employeeService, times(1)).getAllEmployees();
    }

    @Test @DisplayName("Controller Test 3: Get Employee by ID") void shouldGetEmployeeById() throws Exception {
        when(employeeService.getEmployeeById(1L)).thenReturn(employee);

        mockMvc.perform(get("/api/employees/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isFound())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.fullName").value("Prabhas"))
                .andExpect(jsonPath("$.salary").value(60000));

        verify(employeeService, times(1)).getEmployeeById(1L);
    }

    @Test @DisplayName("Controller Test 4: Put Employee") void shouldUpdateEmployee() throws Exception {
        when(employeeService.updateEmployee(any(Employee.class))).thenReturn(employee);

        employee.setFullName("Rajinikanth");

        String json = new ObjectMapper().writeValueAsString(employee);

        mockMvc.perform(put("/api/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fullName").value("Rajinikanth"));

        verify(employeeService, times(1)).updateEmployee(any(Employee.class));
    }

    @Test @DisplayName("Controller Test 5: Delete Employee") void shouldDeleteEmployee() throws Exception {
        doNothing().when(employeeService).deleteEmployee(1L);

        mockMvc.perform(delete("/api/employees/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(employeeService, times(1)).deleteEmployee(1L);
    }

}