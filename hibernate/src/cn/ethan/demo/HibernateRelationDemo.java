package cn.ethan.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.ethan.model.Contact;
import cn.ethan.model.Customer;

public class HibernateRelationDemo {
	//一对多级联保存
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
			
			Customer customer = new Customer();
			customer.setCustName("腾讯");
			customer.setCustLevel("svip");
			customer.setCustSource("互联网");
			customer.setCustPhone("159");
			customer.setCustMobile("182");
			
			Contact contact = new Contact();
			contact.setName("zmr");
			contact.setGender("男");
			contact.setPhone("132");
			contact.setCustomer(customer);
			
			customer.getSetContact().add(contact);
			
			session.save(customer);
			session.save(contact);
			
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
	 * 一对多级联保存简化写法
	 * 1.在客户映射文件中进行配置
	 * 	在客户映射文件中set标签进行配置：增加cascade属性
	 * 2.创建客户和联系人对象，只需要把联系人放到客户里面就可以了
	 */
	@Test
	public void testAdd2() {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction ts = null;
		try {
			sessionFactory = cfg.buildSessionFactory();
			session = sessionFactory.openSession();
			ts = session.beginTransaction();
			
			Customer customer = new Customer();
			customer.setCustName("网易");
			customer.setCustLevel("vip");
			customer.setCustSource("互联网");
			customer.setCustPhone("443");
			customer.setCustPhone("556");
			
			Contact contact = new Contact();
			contact.setName("jerry");
			contact.setGender("男");
			contact.setPhone("123456");
			
			customer.getSetContact().add(contact);
			session.save(customer);
			
			ts.commit();
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
	//一对多级联查询
	@Test
	public void testSelect() {
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
			Contact contact = session.get(Contact.class, 1);
			//设置持久态对象值
			customer.getSetContact().add(contact);
			contact.setCustomer(customer);
			
			
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
