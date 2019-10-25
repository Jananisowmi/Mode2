package com.jwt.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "student")
public class Student implements Serializable {

	private static final long serialVersionUID = -3465813074586302847L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	
	@Column
	private int rollNum;

	@Column
	private String  sName;

	@Column
	private int age;

	@Column
	private String gender;                   
	
	@Column
	private String country;
	
	@Column
	private Date dateOfJoin;
	
	@Column
	private double finalScore;
	
	@Transient
	private String grade;

	
	public String getGrade() {
       GradeInterface gInterface=(double x) -> { String grade = x <=40 ? "FAIL" : x<=60 ? "AVERAGE" : x<=75 ? "FIRST CLASS" : "DISTINCTION" ;return grade;};
       return gInterface.getGrade(finalScore);
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRollNum() {
		return rollNum;
	}

	public void setRollNum(int rollNum) {
		this.rollNum = rollNum;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getDateOfJoin() {
		return dateOfJoin;
	}

	public void setDateOfJoin(Date dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}

	public double getFinalScore() {
		return finalScore;
	}

	public void setFinalScore(double marks) {
		this.finalScore = marks;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
 

}