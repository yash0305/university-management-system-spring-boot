package com.yash.university_management_system.controller;

import org.springframework.web.bind.annotation.RestController;

import com.yash.university_management_system.entity.YashLogin;
import com.yash.university_management_system.repository.UserRepository;
import com.yash.university_management_system.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class AdminLogin {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/admin")
    public List<YashLogin> getAllAdmin() {
        return userRepository.findAllAdmin();
    }
    
    @PostMapping("/admin")
    public String registerUser(@RequestBody YashLogin entity) {
        
        userService.registerUser(entity.getUsername(), entity.getPassword());
        return "Admin added successfully";

    }
    


}
