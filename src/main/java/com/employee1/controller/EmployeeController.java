package com.employee1.controller;

import com.employee1.model.Employee;
import com.employee1.service.EmployeeService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	
	private static final Logger LOG = LogManager.getLogger(EmployeeController.class);
	
	
    @Autowired
    private EmployeeService employeeservice;
    @GetMapping("/get")
    public ResponseEntity<List<Employee>> getAll(){
    	LOG.info("Getting Employee");
        return ResponseEntity.ok(employeeservice.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeservice.findById(id).orElse(null));
    }
    @PostMapping("/add")
    public ResponseEntity<Employee> addAll(@RequestBody Employee emp)
    {
    	LOG.info("Adding Employee");
        return ResponseEntity.ok(employeeservice.save(emp));
    }
    @PutMapping("/update")
    public ResponseEntity<Employee> update(@RequestBody Employee employee) {
    	
    	LOG.info("Updating Employee");
        return ResponseEntity.ok(employeeservice.save(employee));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> delete(@PathVariable Long id) {
        employeeservice.findById(id).ifPresent(employeeservice::delete);
        LOG.info("Deleting Employee");
        return ResponseEntity.ok().build();
    }

}
