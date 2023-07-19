package com.joins;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {
	@Id
	private int projId;
	private String name;

//	@ManyToMany
//	private List<Employee> empLst;

	public int getProjId() {
		return projId;
	}

	public void setProjId(int projId) {
		this.projId = projId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public List<Employee> getEmpLst() {
//		return empLst;
//	}
//
//	public void setEmpLst(List<Employee> empLst) {
//		this.empLst = empLst;
//	}
}
