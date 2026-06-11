package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // interface responsible for data access
public interface StudentRepository extends JpaRepository<Student,Integer> { // JPA Repo to access data
    // to check student with give mail -  select * from student where email = "given_email";
    Optional<Student> findStudentByEmail(String email);

}
