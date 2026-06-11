package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
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

    public void deleteStudent(Integer studentID) {
        boolean exists = studentRepository.existsById(studentID);
        if(!exists){
            throw new IllegalStateException("student with id "+studentID+" does not exists");
        }
        studentRepository.deleteById(studentID);
    }

    @Transactional
    public void updateStudent(Integer studentId, String name, String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(()->new IllegalStateException(
                        "student with id "+studentId+" does not exists"
                ));

        if(name!= null && name.length()>0 && !Objects.equals(student.getName(),name)){
            student.setName(name);
        }

        if(email!= null && email.length()>0 && !Objects.equals(student.getEmail(),email)){

            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }

            student.setEmail(email);
        }

        System.out.println("After Update:"+student);
        studentRepository.save(student);
    }
}
