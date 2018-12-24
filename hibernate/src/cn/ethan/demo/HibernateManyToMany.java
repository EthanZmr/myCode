package cn.ethan.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.ethan.entity.Role;
import cn.ethan.entity.User;

public class HibernateManyToMany {
	//多对多级联保存
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
			user.setUser_name("张三");
			user.setUser_password("1234576");
			
			User user2 = new User();
			user2.setUser_name("李四");
			user2.setUser_password("111111");
			
			Role role = new Role();
			role.setRole_name("保安");
			role.setRole_memo("保安角色");
			
			Role role2 = new Role();
			role2.setRole_name("总经理");
			role2.setRole_memo("总经理角色");
			
			Role role3 = new Role();
			role3.setRole_name("秘书");
			role3.setRole_memo("秘书角色");
			
			user.getSetRole().add(role);
			user.getSetRole().add(role2);
			
			user2.getSetRole().add(role2);
			user2.getSetRole().add(role3);
			
			session.save(user);
			session.save(user2);
			
			ts.commit();
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
	//维护用户和角色的关系表 第三张表
	@Test
	public void UpdateRelationTable() {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction ts = null;
		try {
			sessionFactory = cfg.buildSessionFactory();
			session = sessionFactory.openSession();
			ts = session.beginTransaction();
			
			User zhangsan = session.get(User.class, 1);
			Role manager = session.get(Role.class, 2);
			zhangsan.getSetRole().remove(manager);
			
			ts.commit();
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
	//多对多级联删除(一般不用)
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
			
			User user = session.get(User.class, 1);
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
	
}
