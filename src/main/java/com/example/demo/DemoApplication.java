package com.example.demo;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication implements ApplicationRunner {

    @Autowired
    private EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run (ApplicationArguments arg0) throws Exception {
        //Loading sample dummy data
//        String name, String lastName, String number, String department
        this.employeeRepository.save(new Employee("Fausto", "Torres", "0121", "TI"));
        this.employeeRepository.save(new Employee("Nahara", "Rosario", "0122", "RH"));
        this.employeeRepository.save(new Employee("Gertrudis", "Torres", "0123", "ING"));
        this.employeeRepository.save(new Employee("Ramon", "Diaz", "0124", "ING"));
        this.employeeRepository.save(new Employee("Massiel", "Diaz", "0125", "TI"));
        this.employeeRepository.save(new Employee("Belkis", "Liriano", "0126", "RH"));
    }

//    @Bean
//    ApplicationRunner init(EmployeeRepository employeeRepository) {
//        //Loading sample dummy data
//    }

}
