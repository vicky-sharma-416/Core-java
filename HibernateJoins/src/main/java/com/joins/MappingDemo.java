package com.joins;

import java.util.List;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo {

	public static void main(String[] args) {
		Configuration confObj = new Configuration();
		confObj.configure("hibernate.configuration.xml");
		
		SessionFactory sfObj = confObj.buildSessionFactory();
		Session sessionObj = sfObj.openSession();
		Transaction trx = sessionObj.beginTransaction();

		Employee emp1 = new Employee();
		Employee emp2 = new Employee();

		Project proj1 = new Project();
		Project proj2 = new Project();

		emp1.setEmpId(101);
		emp1.setName("Vikas");

		emp2.setEmpId(102);
		emp2.setName("Sharma");

		proj1.setProjId(11);
		proj1.setName("PMI Central");

		proj2.setProjId(12);
		proj2.setName("Apple");

		List<Project> projectList = new ArrayList<Project>();
		List<Employee> employeeList = new ArrayList<Employee>();
		
		projectList.add(proj1);
		employeeList.add(emp1);
		employeeList.add(emp2);

		emp1.setProjects(projectList);
		emp2.setProjects(projectList);
		//proj1.setEmpLst(employeeList);

		sessionObj.save(emp1);
		sessionObj.save(emp2);
		sessionObj.save(proj1);
		sessionObj.save(proj2);
		
		trx.commit();
		sessionObj.close();
		sfObj.close();
	}
}