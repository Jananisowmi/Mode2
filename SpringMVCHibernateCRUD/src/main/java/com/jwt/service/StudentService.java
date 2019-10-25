package com.jwt.service;

import java.util.List;

import com.jwt.model.Student;

public interface StudentService {
	
	public void addStudent(Student employee);

	public List<Student> getAllStudents();

	public void deleteStudent(Integer employeeId);

	public Student getStudent(int employeeid);

	public Student updateStudent(Student employee);
}
