package com.example.demo;

import com.example.demo.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
@RestController  // makes the class restful - make restful api
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@GetMapping
	public String hello(){
		// basic get endpoint
		return "Hello World";
	}

	@GetMapping("/view")
	public List<Student> getStudents(){
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
