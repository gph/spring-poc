package com.example.demo.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {
    @GetMapping
    public List<Student> getStudents() {
        LocalDate birthday = LocalDate.of(1980, Month.APRIL, 1);
        long daysDifference = ChronoUnit.DAYS.between(birthday, LocalDate.now());

        return List.of(new Student(1L, "Maria", "maria@example.com", birthday, (int) daysDifference / 365));
    }
}
