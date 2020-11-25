package com.springboot.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.student.model.Student;
import com.springboot.student.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	public Student getStudent(int studentId){
		return studentRepository.getStudent(studentId);
	}
	
	public List<Student> getAllStudents() {
		return studentRepository.getAllStudents();
	}
	
	public List<Student> addStudent(Student student) {
		return studentRepository.addStudent(student);
	}
}
