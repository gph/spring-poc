package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Configuration
public class StudentConfig {
    LocalDate birthday = LocalDate.of(1980, Month.APRIL, 1);
    long daysDifference = ChronoUnit.DAYS.between(birthday, LocalDate.now());

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student maria = new Student(
                    "Maria",
                    "maria@example.com",
                    birthday,
                    (int) daysDifference / 365
            );
            Student john = new Student(
                    "John",
                    "john@example.com",
                    birthday,
                    (int) daysDifference / 365
            );

            repository.saveAll(
                    List.of(maria, john)
            );
        };

    }
}
