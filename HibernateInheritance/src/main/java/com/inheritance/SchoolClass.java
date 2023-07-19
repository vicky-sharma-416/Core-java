package com.inheritance;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "school_class")
public class SchoolClass extends SchoolSubject {
	private int classId;
	private String className;

	public SchoolClass() {
		super();
	}
	
	public SchoolClass(int classId, String className, int id, String name) {
		super(id,name);
		//super();
		this.classId= classId;
		this.className = className;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
}
