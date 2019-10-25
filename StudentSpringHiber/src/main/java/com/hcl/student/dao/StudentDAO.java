package com.hcl.student.dao;

import java.util.List;

import com.hcl.student.model.Student;



public interface StudentDAO {
	public String addStudent(Student student);
	public List<Student> getStudent(int rollNum);
	public void updateStudent(int rollNum);

}
