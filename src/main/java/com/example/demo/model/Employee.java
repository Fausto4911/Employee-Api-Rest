package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long iD;
    private String name;
    private String lastName;
    private String number;
    private String department;

    public Employee() {

    }

    public Employee(Long iD, String name, String lastName, String number, String department) {
        this.iD = iD;
        this.name = name;
        this.lastName = lastName;
        this.number = number;
        this.department = department;
    }

    public Employee(String name, String lastName, String number, String department) {
        this.name = name;
        this.lastName = lastName;
        this.number = number;
        this.department = department;
    }

    public Long getiD() {
        return iD;
    }

    public void setiD(Long iD) {
        this.iD = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
