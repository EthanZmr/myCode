package cn.ethan.anno_service;

import cn.ethan.dao.UserDao;

public class UserService {
	
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void add() {
		System.out.println("service.......");
		userDao.add();
	}
}
