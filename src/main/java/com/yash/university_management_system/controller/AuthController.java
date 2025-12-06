package com.yash.university_management_system.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yash.university_management_system.dto.LoginRequest;
import com.yash.university_management_system.dto.LoginResponse;
import com.yash.university_management_system.entity.YashLogin;
import com.yash.university_management_system.repository.UserRepository;
import com.yash.university_management_system.util.JwtUtil;


@RestController
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

   @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {

        YashLogin user = userRepository.findByUsername(req.getUsername());

        if (user != null && passwordEncoder.matches(req.getPassword(), user.getPassword())) {

            String token = jwtUtil.generateToken(user.getUsername());

            LoginResponse response = new LoginResponse(
                    user.getUsername(),
                    token
            );

            return ResponseEntity.ok(response);
        }

        return ResponseEntity.status(401).body("Invalid credentials");
    }
}