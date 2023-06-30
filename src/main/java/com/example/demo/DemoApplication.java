package com.example.demo;

import com.example.demo.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.util.List;

@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping
    public List<Student> hello() {
        LocalDate birthday = LocalDate.of(1980, Month.APRIL, 1);
        long daysDifference = ChronoUnit.DAYS.between(birthday, LocalDate.now());

        return List.of(
                new Student(
                        1L,
                        "Maria",
                        "maria@example.com",
                        birthday,
                        (int) daysDifference / 365
                )
        );
    }

}