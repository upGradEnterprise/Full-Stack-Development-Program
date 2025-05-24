package com.zeta.endtoendtesting.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @Data @Entity @NoArgsConstructor @Table(name = "employees")
public class Employee {
    @Id @GeneratedValue private long id;
    private String fullName;
    private double salary;
}