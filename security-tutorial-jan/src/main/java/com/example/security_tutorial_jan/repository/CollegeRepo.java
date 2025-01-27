package com.example.security_tutorial_jan.repository;

import com.example.security_tutorial_jan.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollegeRepo extends JpaRepository<Person,Integer> {

    Person findByUsername(String username);
}
