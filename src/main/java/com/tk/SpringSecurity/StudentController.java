package com.tk.SpringSecurity;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController

public class StudentController {

    private List<Student> students = new ArrayList<>(List.of(
            new Student(1, "Tanvi",100),
            new Student(2,"Rakshit",98)


    ));

    @GetMapping("/students")
    public List<Student> getStudents()
    {
        return students;
    }

    // WHILE USING POST REQUESTS USING SPRING AUTH, CSRF TOKEN IS REQ, OTHERWISE REQ UNAUTHORIZED

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request)
    {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) // Takes the JSON data from the request body and automatically converts it into a Student object using Jackson (Spring Boot's default JSON parser).
    {
        students.add(student);
        return student;
    }

}
