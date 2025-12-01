package com.yash.university_management_system.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

     @GetMapping
    public ResponseEntity<?> getProducts() {
        String[] product= {"Pasta", "cookies", "cake"};
        return ResponseEntity.ok(product);
    }
}
