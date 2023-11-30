package com.example.litalab1employeeapplication.conf;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = {"com.example.litalab1employeeapplication.entity"})
@EnableJpaRepositories(basePackages = {"com.example.litalab1employeeapplication.repository"})
public class AppConfig {
}
