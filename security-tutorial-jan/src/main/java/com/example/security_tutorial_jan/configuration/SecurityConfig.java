package com.example.security_tutorial_jan.configuration;

import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/home").permitAll()
                .requestMatchers("/student").hasRole("STUDENT")
                .requestMatchers("/admin").hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();
        return httpSecurity.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user1 = User.builder()
                .username("kohli")
                .password(passwordEncoder().encode("kohli123"))
                .roles("STUDENT")
                .build();

        UserDetails user3 = User.builder()
                .username("bumrah")
                .password(passwordEncoder().encode("bumrah123"))
                .roles("STUDENT")
                .build();

        UserDetails user2 = User.builder()
                .username("rohit")
                .password(passwordEncoder().encode("rohit123"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user2,user1,user3);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
