package com.csvReader;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="csv_employee")
public class CsvEmloyee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "emp_id")
	public int id;
	
	@Column(name = "emp_salary")
	public double salary;
	
	@Column(name = "emp_name")
	public String name;
	
	public CsvEmloyee() {
		super();
	}
	
	public CsvEmloyee(int id, double salary) {
		this.id = id;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "ReadCsvEntity [emp_id=" + id + ", emp_name=" + name + ", emp_sal=" + salary + "]";
	}
}
