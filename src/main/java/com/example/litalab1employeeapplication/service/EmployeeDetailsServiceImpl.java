package com.example.litalab1employeeapplication.service;

import com.example.litalab1employeeapplication.entity.Employee;
import com.example.litalab1employeeapplication.entity.UserInfo;
import com.example.litalab1employeeapplication.repository.EmployeeRepository;
import com.example.litalab1employeeapplication.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private EmployeeRepository repository;

    @Override
    public EmployeeDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Employee> employeeDetails = repository.findByUsername(username);

        // Converting userDetail to UserDetails
        return employeeDetails.map(EmployeeDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("Employee not found " + username));
    }

}
