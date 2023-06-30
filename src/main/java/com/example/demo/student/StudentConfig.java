package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student maria = new Student(
                    "Maria",
                    "maria@example.com",
                    LocalDate.of(2015, Month.APRIL, 1)
            );
            Student john = new Student(
                    "John",
                    "john@example.com",
                    LocalDate.of(1980, Month.APRIL, 1)
            );

            repository.saveAll(
                    List.of(maria, john)
            );
        };

    }
}
