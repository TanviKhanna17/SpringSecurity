package com.tk.SpringSecurity;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String greet(HttpServletRequest request) // Provides details about incoming request
    {
        return "Welcome to Tanvi's Home : " + request.getSession().getId();
    }
}
