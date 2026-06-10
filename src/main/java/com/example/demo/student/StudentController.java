package com.example.demo.student;

import com.example.demo.student.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// API Layer
@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    // access the studentservice class object.
    private final StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> viewStudent(){
        return studentService.viewStudent();
    }
}
