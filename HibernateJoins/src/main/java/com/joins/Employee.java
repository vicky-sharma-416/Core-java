package com.joins;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

@Entity
public class Employee {
	@Id
	private int empId;
	private String name;
	
	@ManyToMany
	@JoinTable(name = "employee_project",
		joinColumns = {@JoinColumn(name="empId")},
		inverseJoinColumns = {@JoinColumn(name="projId")})
	private List<Project> projectLst;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Project> getProjects() {
		return projectLst;
	}

	public void setProjects(List<Project> projectLst) {
		this.projectLst = projectLst;
	}
}
