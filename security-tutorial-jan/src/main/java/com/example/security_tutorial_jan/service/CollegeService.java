package com.example.security_tutorial_jan.service;

import com.example.security_tutorial_jan.model.Person;
import com.example.security_tutorial_jan.repository.CollegeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CollegeService {

    @Autowired
    CollegeRepo collegeRepo;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String addPerson(Person person) {
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        person.setRoles("STUDENT");
        collegeRepo.save(person);
        return "Person saved";
    }
}
