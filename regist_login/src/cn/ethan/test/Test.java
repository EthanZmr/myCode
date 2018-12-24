package cn.ethan.test;

import cn.ethan.dao.UserDao;
import cn.ethan.model.User;

public class Test {
	@org.junit.Test
	public void testFindByUsername() {
		UserDao userDao = new UserDao();
		User user = new User();
		user.setUsername("zmr");
		user.setPassword("12345678");
		userDao.add(user);
		
	}
	
	@org.junit.Test
	public void testFind() {
		UserDao userDao = new UserDao();
		User user = userDao.findByUserName("zmr");
		System.out.println(user);
		
	}
}
