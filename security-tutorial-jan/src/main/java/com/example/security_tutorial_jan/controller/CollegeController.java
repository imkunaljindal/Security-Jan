package com.example.security_tutorial_jan.controller;

import com.example.security_tutorial_jan.model.Person;
import com.example.security_tutorial_jan.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CollegeController {

    @Autowired
    CollegeService collegeService;

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

    @PostMapping("/signup")
    public String addPerson(@RequestBody Person person) {
        return collegeService.addPerson(person);
    }
}
