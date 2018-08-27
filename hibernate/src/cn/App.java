package cn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class App {
	@Test
	public void testHello() throws Exception {
		People people=new People();
		
		people.setName("×å³¤");
		people.setAge("20");
		Configuration configuration=new Configuration();
		configuration.configure();
		SessionFactory sf=configuration.buildSessionFactory();
		Session  session=sf.openSession();
		Transaction tx=session.beginTransaction();
		session.save(people);
		tx.commit();
		session.close();
		sf.close();
	}
}
