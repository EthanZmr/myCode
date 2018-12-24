package cn.ethan.demo;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.ethan.model.Contact;
import cn.ethan.model.Customer;

public class HiberanteHQLDemo {
	
	@Test
	public void add() {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction ts = null;
		try {
			sessionFactory = cfg.buildSessionFactory();
			session = sessionFactory.openSession();
			ts = session.beginTransaction();
			
			Customer ct1 = new Customer();
			ct1.setCustName("百度");
			ct1.setCustLevel("vip");
			ct1.setCustSource("互联网");
			ct1.setCustPhone("110");
			ct1.setCustMobile("999");
			
			Customer ct2 = new Customer();
			ct2.setCustName("阿里巴巴");
			ct2.setCustLevel("svip");
			ct2.setCustSource("互联网");
			ct2.setCustPhone("111");
			ct2.setCustMobile("998");
			
			Contact c = new Contact();
			c.setName("Harry");
			c.setGender("男");
			c.setPhone("129");
			c.setCustomer(ct2);
			
			Contact c2 = new Contact();
			c2.setName("lucy");
			c2.setGender("女");
			c2.setPhone("120");
			c2.setCustomer(ct2);
			
			session.save(ct1);
			session.save(ct2);
			session.save(c);
			session.save(c2);
			
			ts.commit();
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
	/*
	 * HQL聚合函数
	 */
	@Test
	public void testCount() {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction ts = null;
		try {
			sessionFactory = cfg.buildSessionFactory();
			session = sessionFactory.openSession();
			ts = session.beginTransaction();
			
			Query query = session.createQuery("select count(*) from User");
			Object object = query.uniqueResult();
			Long obj = (Long)object;
			int count = obj.intValue();
			System.out.println(count);
			
			ts.commit();
		} catch (Exception e) {
			e.printStackTrace();
			ts.commit();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
	/*
	 * 对象导航查询
	 */
	@Test
	public void testObjectSelect() {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction ts = null;
		try {
			sessionFactory = cfg.buildSessionFactory();
			session = sessionFactory.openSession();
			ts = session.beginTransaction();
			
			//查询cid=10的客户 再查询这个客户所有的联系人
			Customer customer = session.get(Customer.class, 10);
			Set<Contact> list = customer.getSetContact();
			for (Contact contact : list) {
				System.out.println(contact);
			}
			
			ts.commit();
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
	/*
	 * HQL查询所有
	 */
	@Test
	public void testFindAll() {
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
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
	/**
	 * HQL条件查询
	 */
	@Test
	public void SearchByCondition() {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction ts = null;
		try {
			sessionFactory = cfg.buildSessionFactory();
			session = sessionFactory.openSession();
			ts = session.beginTransaction();
			
			Query query = session.createQuery("from Customer where cid=?0 and custName=?1");
			query.setParameter(0, 10);
			query.setParameter(1, "阿里巴巴");
			
			List<Customer> list = query.list();
			for (Customer customer : list) {
				System.out.println(customer);
			}
			
			ts.commit();
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
	/*
	 * HQL模糊查询
	 */
	@Test
	public void searchLike() {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction ts = null;
		try {
			sessionFactory = cfg.buildSessionFactory();
			session = sessionFactory.openSession();
			ts = session.beginTransaction();
			
			Query query = session.createQuery("from Customer where custName like ?0");
			query.setParameter(0, "%巴%");
			List<Customer> list = query.list();
			for (Customer customer : list) {
				System.out.println(customer);
			}
			
			
			ts.commit();
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
	/*
	 * HQL排序查法
	 */
	@Test
	public void testOrders() {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction ts = null;
		try {
			sessionFactory = cfg.buildSessionFactory();
			session = sessionFactory.openSession();
			ts = session.beginTransaction();
			
			Query query = session.createQuery("from Customer order by cid desc");
			List<Customer> list = query.list();
			for (Customer customer : list) {
				System.out.println(customer);
			}
			
			ts.commit();
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
	/*
	 * HQL 分页查询
	 */
	@Test
	public void pageSet() {
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
			query.setFirstResult(0);
			query.setMaxResults(1);
			List<Customer> list = query.list();
			for (Customer customer : list) {
				System.out.println(customer);
			}
			
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
