package com.hcl.student.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hcl.student.model.HibernateUtil;
import com.hcl.student.model.Student;

public class StudentDAOImpl implements StudentDAO {

	public String addStudent(Student student) {
			 SessionFactory sf=HibernateUtil.getConnection();
			 Session s=sf.openSession();
			 Transaction t=s.beginTransaction();
			 s.save(student);
			 t.commit();
			 return "Record Inserted....";
		}
	
	

	public List<Student> getStudent(int rollNum) {
		return null;
	}

	public void updateStudent(int rollNum) {
	}
}

	 
	
