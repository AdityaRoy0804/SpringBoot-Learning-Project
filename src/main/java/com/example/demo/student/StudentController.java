package com.example.demo.student;

import com.example.demo.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// API Layer
@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    // access the studentservice class object.
    private final StudentService studentService;

    @Autowired // used for dependency injection
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    @GetMapping
    public List<String> health_status(){
        return List.of(
                "Status: 200",
                "API Running"
        );
    }
    @GetMapping("/view")
    public List<Student> viewStudent(){
        return studentService.viewStudent();
    }

    @PostMapping("/add")
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }
}
