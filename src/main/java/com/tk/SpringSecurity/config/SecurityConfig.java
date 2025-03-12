package com.tk.SpringSecurity.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // Marks this class as a Spring configuration class. It allows Spring to detect and load security settings at startup.
@EnableWebSecurity // Enables Spring Security in your application.
// Automatically applies security settings to all HTTP requests.
public class SecurityConfig {


    // FOLLOWING METHOD APPLIES CUSTOMIZATIONS TO SPRING SECURITY RULES TO INCOMING HTTP REQUESTS
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(customizer -> customizer.disable()); // DISABLING CSRF TOKEN
        http.authorizeHttpRequests(request-> request.anyRequest().authenticated());
        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
