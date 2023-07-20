package com.csvReader.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ReadCsvDto {
	
	public boolean insert(List data) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.config.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
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

}
