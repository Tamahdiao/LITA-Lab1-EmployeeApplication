package com.example.litalab1employeeapplication.repository;

import com.example.litalab1employeeapplication.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {
        Optional<Employee> findByUsername(String username);
}
