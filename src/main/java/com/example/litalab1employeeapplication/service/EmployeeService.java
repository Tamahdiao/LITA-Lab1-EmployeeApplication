package com.example.litalab1employeeapplication.service;

import com.example.litalab1employeeapplication.entity.Employee;
import com.example.litalab1employeeapplication.entity.UserInfo;
import com.example.litalab1employeeapplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    public Employee addEmployee(Employee employee) {
        employee.setPassword(encoder.encode(employee.getPassword()));
        repository.save(employee);
        return employee;
    }


}
