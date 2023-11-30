package com.example.litalab1employeeapplication.Controller;

import com.example.litalab1employeeapplication.entity.UserInfo;
import com.example.litalab1employeeapplication.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserInfoService service;


    @GetMapping("/userProfile")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String userProfile() {
        return "Welcome to User Profile";
    }

    @GetMapping("/adminProfile")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String adminProfile() {
        return "Welcome to Admin Profile";
    }


    @GetMapping("/user/{username}")
     @PreAuthorize("principal.username == #username")
    public UserInfo findUserByUsername(@PathVariable  String username) {
        return service.findUserByUsername(username);
    }
}




