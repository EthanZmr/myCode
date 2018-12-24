package cn.ethan.demo;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import cn.ethan.model.User;

public class HibernateQBCDemo {
	/*
	 * QBC查询所有
	 */
	@Test
	public void testQBCSelectAll() {
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
	 * QBC条件查询
	 */
	@Test
	public void testCondition() {
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
			//使用add方法表示设置条件值
			//在add方法参数中使用类的方法实现条件设置
			ct.add(Restrictions.eq("uid", 1));
			ct.add(Restrictions.eq("username", "张三"));
			//模糊查询
//			ct.add(Restrictions.like("username", "%三%"))
			List<User> list = ct.list();
			for (User user : list) {
				System.out.println(list);
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
	 * QBC排序查询
	 */
	@Test
	public void testOrder() {
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
			//排序
			ct.addOrder(Order.desc("uid"));
			
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
	 * QBC分页查询
	 */
	@Test
	public void testPage() {
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
			//设置分页数据（从第几条数据开始）
			ct.setFirstResult(0);
			//设置每页记录数
			ct.setMaxResults(2);
			
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
	 * QBC统计查询
	 */
	@Test
	public void testCount() {
		Configuration cfg = new Configuration();
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction ts = null;
		try {
			sessionFactory = cfg.buildSessionFactory();
			session = sessionFactory.openSession();
			ts = session.beginTransaction();
			
			Criteria ct = session.createCriteria(User.class);
			//设置操作
			ct.setProjection(Projections.rowCount());
			//调用方法得到结果
			Object object = ct.uniqueResult();
			Long obj = (Long)object;
			int count = obj.intValue();
			System.out.println(count);
			
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
	 * QBC离线查询
	 */
	@Test
	public void testOFFLine() {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction ts = null;
		try {
			sessionFactory = cfg.buildSessionFactory();
			session = sessionFactory.openSession();
			ts = session.beginTransaction();
			
			DetachedCriteria dc = DetachedCriteria.forClass(User.class);
			Criteria ct = dc.getExecutableCriteria(session);
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
}
