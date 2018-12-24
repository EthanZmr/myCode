package cn.ethan.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import cn.ethan.dao.UserDao;
import cn.ethan.entity.User;

public class UserDaoImpl implements UserDao{
	
	//得到hibernateTemplate对象
	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void add() {
//		HibernateTemplate hibernateTemplate = new HibernateTemplate(sessionFactory);
//		User user = new User();
//		user.setUid(1);
//		user.setUsername("张三");
//		user.setAddress("中国");
//		hibernateTemplate.save(user);
		
		//get方法 根据id查询
//		User user = hibernateTemplate.get(User.class, 3);
//		System.out.println(user);
		
		//find查询表中的所有记录  第一个参数是hql语句
//		List<User> list = (List<User>) hibernateTemplate.find("from User");
//		for (User user : list) {
//			System.out.println(user);
//		}
		
		//分页
		//hibernateTemplate.findByCriteria(criteria, firstResult, maxResults)
		
		//find条件查询
		List<User> list = (List<User>) hibernateTemplate.find("from User where username=?0", "张三");
		for (User user : list) {
			System.out.println(user);
		}
	}
	
}
