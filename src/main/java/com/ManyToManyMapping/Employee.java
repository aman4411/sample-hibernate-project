package com.ManyToManyMapping;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Employee {

	@Id
	@Column(name="employee_id")
	private int employeeId;
	
	private String name;
	
	@ManyToMany
	@JoinTable( 
			name="Employee_Project_Mapping", 
			joinColumns = { @JoinColumn(name="eid") }, 
			inverseJoinColumns = { @JoinColumn(name="pid")}
	)
	private List<Project> projects;
	
	public Employee(int employeeId, String name, List<Project> projects) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.projects = projects;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	
}
