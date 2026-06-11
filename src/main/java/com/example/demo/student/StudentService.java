package com.example.demo.student;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired //for dependency injection
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
;
    public List<Student> viewStudent(){
        return studentRepository.findAll(); // return all data (select *)
    }

    public void addNewStudent(Student student) {
        System.out.println(student); // print to check before sending to data layer.

        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if(studentByEmail.isPresent()){ //student with same email - flag error
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
    }
}
