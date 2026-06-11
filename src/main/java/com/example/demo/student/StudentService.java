package com.example.demo.student;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {
    public List<Student> viewStudent(){
        return List.of(
                new Student(
                        1,
                        "Aditya",
                        21,
                        LocalDate.of(2004, Month.JULY,8),
                        "xyz@gmail.com"
                )
        );
    }
}
