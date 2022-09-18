package com.springoorm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="studentdeatails")
public class Student {
	
	//data members
	@Id
	@Column(name="studentId")
	private int studentId;
	@Column(name="studentName")
	private String studentName;
	@Column(name="studentCity")
	private String StudentCity;
	
	//Parameterized constructor
	public Student(int studentId, String studentName, String studentCity) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		StudentCity = studentCity;
	}
	//default constructor
	public Student() {
		super();
	}
	
	//Getters and setters
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentCity() {
		return StudentCity;
	}

	public void setStudentCity(String studentCity) {
		StudentCity = studentCity;
	}
}