package cn.ethan.service;

import cn.ethan.dao.UserDao;

public class UserService {
	
	//注入dao对象
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void add() {
		System.out.println("service....");
		userDao.add();
	}

}
