package com.example.litalab1employeeapplication.repository;

import com.example.litalab1employeeapplication.entity.Contribution;
import com.example.litalab1employeeapplication.entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ContributionRepository extends CrudRepository<Contribution,Long> {
   List<Contribution> findContributionByEmployee_Username(String username);
}