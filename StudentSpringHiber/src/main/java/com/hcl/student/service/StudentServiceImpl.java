package com.hcl.student.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.student.dao.StudentDAO;
import com.hcl.student.model.Student;


@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	
	SessionFactory sessionFactory;

	public void addStudent(Student student) {
		sessionFactory.getCurrentSession().saveOrUpdate(student);

	}

	@SuppressWarnings("unchecked")
	public List<Student> getAllStudents() {

		return sessionFactory.getCurrentSession().createQuery("from Student")
				.list();
	}


	public void deleteStudent(Integer employeeId) {
		Student employee = (Student) sessionFactory.getCurrentSession().load(
				Student.class, employeeId);
		if (null != employee) {
			this.sessionFactory.getCurrentSession().delete(employee);
		}

	}

	public Student getStudent(int empid) {
		return (Student) sessionFactory.getCurrentSession().get(
				Student.class, empid);
	}


	public Student updateStudent(Student employee) {
		sessionFactory.getCurrentSession().update(employee);
		return employee;
	}

	public Student getstudent(int studentRollNum) {
		// TODO Auto-generated method stub
		return null;
	}

}