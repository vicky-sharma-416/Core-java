package com.inheritance;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="school_subject")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class SchoolSubject {
	@Id
	private int id;
	private String name;

	public SchoolSubject() {
		super();
	}
	
	public SchoolSubject(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
