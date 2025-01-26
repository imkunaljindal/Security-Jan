package com.example.security_tutorial_jan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CollegeController {

    @GetMapping("/home")
    public String home() {
        return "Welcome to HOME";
    }

    @GetMapping("/student")
    public String student() {
        return "Welcome to the STUDENT page";
    }

    @GetMapping("/admin")
    public String admin() {
        return "Welcome to the ADMIN";
    }
}
