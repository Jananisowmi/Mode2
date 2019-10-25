package com.hcl.student.service;

import java.util.List;

import com.hcl.student.model.Student;


public interface StudentService {
	public void addStudent(Student student);

	public List<Student> getAllStudents();

	public void deleteStudent(Integer studentRollNum);

	public Student getstudent(int studentRollNum);

	public Student updateStudent(Student student);
}


