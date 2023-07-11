package student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainStudent {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.config.xml");

		SessionFactory sessionFactoryObj = cfg.buildSessionFactory();
		Session sessionObj = sessionFactoryObj.openSession();

		Transaction trxObj = sessionObj.beginTransaction();
		
		Student studentObj = new Student();
		studentObj.setId(101);
		studentObj.setName("Test");
		studentObj.setEmail("test@test.com");
		studentObj.setPassword("Test123");
		
		sessionObj.save(studentObj);
		trxObj.commit();
		sessionObj.close();
	}

}
