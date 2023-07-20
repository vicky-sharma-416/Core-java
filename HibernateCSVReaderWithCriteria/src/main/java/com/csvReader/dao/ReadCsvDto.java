package com.csvReader.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.csvReader.CsvEmloyee;

public class ReadCsvDto {
	
	public SessionFactory createSession() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.config.xml");
		
		return cfg.buildSessionFactory();
	}
	
	public boolean insert(List data) {

//		Configuration cfg = new Configuration();
//		cfg.configure("hibernate.config.xml");
//		
//		SessionFactory sf = cfg.buildSessionFactory();
//		Session sessionObj = sf.openSession();

		SessionFactory sf = createSession();
		Session sessionObj = sf.openSession();
		Transaction trx = sessionObj.beginTransaction();
		Serializable serializableObj = null;

		for(int i=0; i<data.size(); i++) {
			serializableObj = sessionObj.save(data.get(i));
		}

		trx.commit();
		sessionObj.close();
		sf.close();

		if(Integer.parseInt(serializableObj.toString()) > 0) {
			return true;
		}
		return false;
	}
	
	public void criteriaData() {
		System.out.println("//------------------------------ Criteria Start ------------------------------");

		SessionFactory sf = createSession();
		Session sessionObj = sf.openSession();

		@SuppressWarnings("deprecation")
		Criteria criteriaObj = sessionObj.createCriteria(CsvEmloyee.class);

		//criteriaObj.add(Restrictions.eq("salary", "4200"));
		criteriaObj.add(Restrictions.like("name", "%R%"));
		
		List<ReadCsvDao> empList = criteriaObj.list();

		for(int index=0; index<empList.size(); index++) {
			System.out.println(empList.toString());
		}
		
		System.out.println("//------------------------------ Criteria End ------------------------------");
	}

}
