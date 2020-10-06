package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee) {
        employee = this.employeeRepository.save(employee);
        return employee;
    }

    public List<Employee> createEmployeeList(List<Employee> employees) {
        List<Employee> savedList = this.employeeRepository.saveAll(employees);
        return savedList;
    }

    public Employee getEmployeeById(Long id) {
        Optional<Employee> result = this.employeeRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
    }

    public Employee getEmployeeByName(String name) {
        return this.employeeRepository.findByName(name);
    }

    public List<Employee> getAllEmployees() {
        return this.employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    public Employee deleteEmployee(Long id) {
        Employee employee = this.getEmployeeById(id);
        if (employee != null) {
            this.employeeRepository.delete(employee);
            return employee;
        } else {
            return null;
        }
    }
}
