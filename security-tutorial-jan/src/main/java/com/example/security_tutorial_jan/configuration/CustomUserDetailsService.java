package com.example.security_tutorial_jan.configuration;

import com.example.security_tutorial_jan.model.Person;
import com.example.security_tutorial_jan.repository.CollegeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    CollegeRepo collegeRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = collegeRepo.findByUsername(username);
        if(person==null) {
            throw new RuntimeException("Invalid username");
        }

//        return person;
        return new CustomUserDetails(person);
    }
}
