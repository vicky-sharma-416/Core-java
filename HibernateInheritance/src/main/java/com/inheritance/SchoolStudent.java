package com.inheritance;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "school_subject")
public class SchoolStudent extends SchoolSubject{
	private int stdentId;
	private String stdentName;

	public SchoolStudent() {
		super();
	}
	
	public SchoolStudent(int stdentId, String stdentName, int id, String name) {
		super(id, name);
		//super();
		this.stdentId = stdentId;
		this.stdentName = stdentName;
	}

	public int getStdentId() {
		return stdentId;
	}

	public void setStdentId(int stdentId) {
		this.stdentId = stdentId;
	}

	public String getStdentName() {
		return stdentName;
	}

	public void setStdentName(String stdentName) {
		this.stdentName = stdentName;
	}
}
