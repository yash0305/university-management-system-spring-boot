package com.yash.university_management_system.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.yash.university_management_system.entity.YashLogin;
import com.yash.university_management_system.repository.UserRepository;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;  // inject encoder

   
    public YashLogin registerUser(String username, String plainPassword, String role) {
        // hash the password
         String hashedPassword = passwordEncoder.encode(plainPassword);
        // create user entity
        YashLogin user = new YashLogin();
        user.setUsername(username);
        user.setPassword(hashedPassword);
        user.setRole(role);

        // save to DB
        return userRepository.save(user);
    }

    

}
