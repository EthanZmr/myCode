package cn.ethan.demo;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.ethan.model.Contact;
import cn.ethan.model.Customer;

public class HibernateLazyDemo {
	//关联级别延迟操作
	@Test
	public void testLazy() {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction ts = null;
		try {
			sessionFactory = cfg.buildSessionFactory();
			session = sessionFactory.openSession();
			ts = session.beginTransaction();
			
			Customer customer = session.get(Customer.class, 10);
			Set<Contact> set = customer.getSetContact();
			System.out.println(set.size());
			
			ts.commit();
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}
