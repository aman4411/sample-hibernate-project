package com.sample_hibernate_project;

import javax.persistence.Entity;
import javax.persistence.Id;

//entity annotation makes class an entity
@Entity
public class Student {

	//Id annotation makes property primary key of table
	@Id
	private String rollNo;
	private String name;
	private String city;
	
	
	public Student(String rollNo, String name, String city) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.city = city;
	}


	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getRollNo() {
		return rollNo;
	}


	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", city=" + city + "]";
	}
	
}
