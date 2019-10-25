package com.jwt.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jwt.model.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addStudent(Student student) {
		sessionFactory.getCurrentSession().saveOrUpdate(student);

	}

	@SuppressWarnings("unchecked")
	public List<Student> getAllStudent() {

		return sessionFactory.getCurrentSession().createQuery("from Student")
				.list();
	}

	@Override
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

	@Override
	public Student updateStudent(Student employee) {
		sessionFactory.getCurrentSession().update(employee);
		return employee;
	}

}