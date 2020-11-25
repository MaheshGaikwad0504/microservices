package com.springboot.student.repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.springboot.student.model.Student;

@Repository
public class StudentRepository {

	private static List<Student> studentList = Arrays.asList(new Student(1, "Mahesh", "Solapur", 78),
			new Student(2, "Rahul", "Tembhurni", 76), new Student(3, "Sachin", "Adhegaon", 87),
			new Student(4, "Ashok", "Wadoli", 88));

	@Cacheable
	public Student getStudent(int studentId) {
		for (Student student : studentList) {
			if (student.getStudentId() == studentId) {
				Student stud = new Student();
				stud.setStudentId(studentId);
				stud.setName(student.getName());
				stud.setMarks(student.getMarks());
				stud.setAddress(student.getAddress());
				return stud;
			}
		}

		return null;
	}

	@Cacheable("studentList")
	public List<Student> getAllStudents() {
		System.out.println("inside repository");
		return studentList;
	}

	public List<Student> addStudent(Student student) {
		Student newStudent = new Student();
		newStudent.setStudentId(student.getStudentId());
		newStudent.setName(student.getName());
		newStudent.setAddress(student.getAddress());
		newStudent.setMarks(student.getMarks());
		studentList.add(newStudent);
		return studentList;
	}

	public List<Student> updateStudent(Student student) {
		Student studentAvailable = getStudent(student.getStudentId());
		if (studentAvailable != null) {
			studentAvailable.setName(student.getName());
			studentAvailable.setMarks(student.getMarks());
			studentAvailable.setAddress(student.getAddress());
			return studentList;
		}
		return Collections.emptyList();
	}
}
