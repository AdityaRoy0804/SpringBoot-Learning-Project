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
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student aditya = new Student(
                    "Aditya",
                    LocalDate.of(2004, Month.JULY,8),
                    "xyz@gmail.com"
            );
            Student ekta = new Student(
                    "Ekta",
                    LocalDate.of(2005, Month.APRIL,12),
                    "abc@gmail.com"
            );
            repository.saveAll(
                    List.of(aditya,ekta)
            );
        };
    }
}
