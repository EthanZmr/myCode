package cn.ethan.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import cn.ethan.dao.CustomerDao;
import cn.ethan.model.Customer;

public class CustomerDaoImpl implements CustomerDao{

	public List<Customer> findAll() {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction ts = null;
		try {
			sessionFactory = cfg.buildSessionFactory();
			session = sessionFactory.openSession();
			ts = session.beginTransaction();
			
			Query query = session.createQuery("from Customer");
			List<Customer> list = query.list();
			
			for (Customer customer : list) {
				System.out.println(customer);
			}
			
			ts.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
		return null;
	}

}
