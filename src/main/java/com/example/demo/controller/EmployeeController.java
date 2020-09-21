package com.example.demo.controller;

import com.example.demo.Exceptions.EmployeeNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return this.employeeService.getAllEmployees();
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = this.employeeService.createEmployee(employee);
        URI uri =  ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedEmployee.getiD())
        .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public Employee updateEmployee(@RequestBody Employee employee) {
        return this.employeeService.updateEmployee(employee);
    }

    @GetMapping(path = "/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        Employee employee = this.employeeService.getEmployeeById(id);
        if(employee == null) throw new EmployeeNotFoundException("Not User Found with ID " + id);
        return employee;
    }

    @DeleteMapping(path ="/{id}")
    public Employee deleteEmployee(@PathVariable Long id) {
        Employee deletedEmployee = this.employeeService.deleteEmployee(id);
        if(deletedEmployee == null) throw new EmployeeNotFoundException("Not User Found with ID " + id);
        return deletedEmployee;
    }
}
