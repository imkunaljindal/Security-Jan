package com.example.security_tutorial_jan.configuration;

import com.example.security_tutorial_jan.model.Person;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {

    String username;
    String password;
    List<GrantedAuthority> authorities;

    public CustomUserDetails(Person person) {
        this.username = person.getUsername();
        this.password = person.getPassword();

        String[] roles = person.getRoles().split(",");
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for(String role: roles) {
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_"+role);
            grantedAuthorities.add(simpleGrantedAuthority);
        }
        this.authorities = grantedAuthorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
