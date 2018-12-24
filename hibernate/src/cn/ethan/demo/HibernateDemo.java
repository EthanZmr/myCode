package cn.ethan.demo;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.ethan.model.User;

public class HibernateDemo {
	@Test
	public void testAdd() {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction ts = null;
		try {
			sessionFactory = cfg.buildSessionFactory();
			session = sessionFactory.openSession();
			ts = session.beginTransaction();
			
			User user = new User();
			user.setUsername("张三");
			user.setPassword("123");
			user.setAddress("美国");
			session.save(user);
			
			ts.commit();
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			
		}
	}
	
	@Test
	public void testGet() {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction ts = null;
		try {
			sessionFactory = cfg.buildSessionFactory();
			session = sessionFactory.openSession();
			ts = session.beginTransaction();
			
			User user  = session.get(User.class, 6);
			System.out.println(user);
			
			ts.commit();
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
	
	@Test
	public void findAll() {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction ts = null;
		try {
			sessionFactory = cfg.buildSessionFactory();
			session = sessionFactory.openSession();
			ts = session.beginTransaction();
			
			Query query = session.createQuery("from User");
			List<User> list = query.list();
			for (User user : list) {
				System.out.println(user);
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
	
	@Test
	public void testUpdate() {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction ts = null;
		try {
			sessionFactory = cfg.buildSessionFactory();
			session = sessionFactory.openSession();
			ts = session.beginTransaction();
			
			User user = session.get(User.class, 6);
			user.setUsername("新垣结衣");
			session.save(user);
			
			ts.commit();
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
	
	@Test
	public void testDelete() {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction ts = null;
		try {
			sessionFactory = cfg.buildSessionFactory();
			session = sessionFactory.openSession();
			ts = session.beginTransaction();
			
			User user = session.get(User.class, 6);
			session.delete(user);
			
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
	 * criteria对象：
	 * 	使用此对象查询操作，不需要写语句，直接调用方法实现
	 * 	1.创建criteria对象
	 * 	2.调用对象中的方法得到结果
	 */
	@Test
	public void testcriteria() {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction ts = null;
		try {
			sessionFactory = cfg.buildSessionFactory();
			session = sessionFactory.openSession();
			ts = session.beginTransaction();
			
			Criteria ct = session.createCriteria(User.class);
			List<User> list = ct.list();
			for (User user : list) {
				System.out.println(user);
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
	 * SQLQuery对象：
	 * 	使用hibernate时调用底层sql实现
	 * 	1.创建对象
	 * 	2.调用对象的方法得到结果
	 */
	@Test
	public void testSQLQuery() {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction ts = null;
		try {
			sessionFactory = cfg.buildSessionFactory();
			session = sessionFactory.openSession();
			ts = session.beginTransaction();
			
			SQLQuery sql = session.createSQLQuery("select * from t_user2");
			sql.addEntity(User.class);
			List<User> list = sql.list();
			for (User user : list) {
				System.out.println(user);
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
