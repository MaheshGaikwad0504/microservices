package com.springboot.student.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.student.model.Student;
import com.springboot.student.service.StudentService;

@RestController
public class StudentController {

	private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	StudentService studentService;

	@GetMapping("/test/{message}")
	public String test(@PathVariable("message") String message) {
		LOGGER.info("inside test..");
		return "Welcome " + message;
	}

	@GetMapping("/students/{studentId}")
	public ResponseEntity<Student> getStudent(@PathVariable int studentId) {
		Student student = null;

		student = studentService.getStudent(studentId);
		if (student == null) {
			return new ResponseEntity<>(student, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(student, HttpStatus.FOUND);
	}

	@GetMapping("/students")
	public List<Student> getAllStudents() {
		LOGGER.info("inside /students at INFO level");
		LOGGER.error("inside /students at ERROR level");
		LOGGER.warn("inside /students at WARN level");
		LOGGER.debug("inside /students at DEBUG level");
		LOGGER.trace("inside /students at TRACE level");
		return studentService.getAllStudents();
	}

	@PostMapping("/students")
	public List<Student> addStudent(@RequestBody Student student) {
		return studentService.addStudent(student);
	}

}
