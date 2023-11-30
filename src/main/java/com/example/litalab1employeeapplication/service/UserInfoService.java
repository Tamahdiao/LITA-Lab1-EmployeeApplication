package com.example.litalab1employeeapplication.service;

import com.example.litalab1employeeapplication.entity.UserInfo;
import com.example.litalab1employeeapplication.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoRepository repository;

    @Autowired
    private PasswordEncoder encoder;


   public UserInfo addUser(UserInfo userInfo) {
          userInfo.setPassword(encoder.encode(userInfo.getPassword()));
//          userInfo.setPassword(userInfo.getPassword());
        repository.save(userInfo);
        return userInfo;
    }

    public UserInfo findUserByUsername(String username) {

        return repository.findByName(username).get();
    }


}