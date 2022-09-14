package com.employee1.controller;

import com.employee1.model.Employee;
import com.employee1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeservice;
    @GetMapping("/get")
    public ResponseEntity<List<Employee>> getAll(){
        return ResponseEntity.ok(employeeservice.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeservice.findById(id).orElse(null));
    }
    @PostMapping("/add")
    public ResponseEntity<Employee> addAll(@RequestBody Employee emp)
    {
        return ResponseEntity.ok(employeeservice.save(emp));
    }
    @PutMapping("/update")
    public ResponseEntity<Employee> update(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeservice.save(employee));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> delete(@PathVariable Long id) {
        employeeservice.findById(id).ifPresent(employeeservice::delete);
        return ResponseEntity.ok().build();
    }

}
