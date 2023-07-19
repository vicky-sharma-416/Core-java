package com.inheritance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SchoolMain {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernat.conf.xml");
		
		SessionFactory sfObj = cfg.buildSessionFactory();
		Session sessionObj = sfObj.openSession();
		Transaction trx = sessionObj.beginTransaction();
		
		SchoolSubject subject = new SchoolSubject(100, "EC");
		SchoolStudent student = new SchoolStudent(11, "Vikas", 101, "CS");
		SchoolClass classSchool = new SchoolClass(21, "ClassA", 102, "IT");
		
		sessionObj.save(student);
		sessionObj.save(classSchool);
		
		trx.commit();
		sessionObj.close();
		sfObj.close();
	}

}
