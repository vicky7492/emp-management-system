package com.employee1.service;

import com.employee1.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeService extends JpaRepository<Employee,Long> {
}
