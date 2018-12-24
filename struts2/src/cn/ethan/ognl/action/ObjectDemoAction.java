package cn.ethan.ognl.action;

import com.opensymphony.xwork2.ActionSupport;

import cn.ethan.ognl.entity.User;

public class ObjectDemoAction extends ActionSupport{
	
	private User user;
	
	@Override
	public String execute() throws Exception {
		//向值栈的user中放数据
		user = new User();
		user.setUsername("lucy");
		user.setPassword("123");
		user.setAddress("中国");
		
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}
}
