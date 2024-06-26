package com.example.dailydumppostservice.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                // Allow registration without authentication
                                .anyRequest().permitAll()  // Require authentication for all other requests
                )
                .csrf(csrf -> csrf.disable())  // Explicitly disable CSRF as per new configuration methods
                .httpBasic(Customizer.withDefaults());  // Use HTTP Basic authentication
        return http.build();
    }

}