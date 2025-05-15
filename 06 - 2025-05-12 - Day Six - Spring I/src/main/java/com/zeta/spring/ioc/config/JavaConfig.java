package com.zeta.spring.ioc.config;

import com.zeta.spring.ioc.bean.Department;
import com.zeta.spring.ioc.bean.Employee;
import com.zeta.spring.ioc.bean.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration public class JavaConfig {
    @Bean public Product product() { return new Product(); }
    @Bean public Employee employee() { return new Employee(); }
    @Bean public Department department() { return new Department(); }
}