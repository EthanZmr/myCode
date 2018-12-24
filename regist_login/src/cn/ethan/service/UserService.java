package cn.ethan.service;

import cn.ethan.dao.UserDao;
import cn.ethan.model.User;

public class UserService {
	private UserDao userDao = new UserDao();
	/*
	 * 注册功能
	 */
	public void regist(User user) throws UserException{
		User _user = userDao.findByUserName(user.getUsername());
		if(_user != null) {
			throw new UserException("该用户已存在");
		}
		userDao.add(user);
	}
	/*
	 * 登录功能
	 */
	public User login(User user) throws UserException{
		User _user = userDao.findByUserName(user.getUsername());
		if(_user == null||!(user.getPassword().equals(_user.getPassword()))) {
			throw new UserException("用户名或密码错误");
		}
		return _user;
	}
}
