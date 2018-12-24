package cn.ethan.ognl.valuestack;

import com.opensymphony.xwork2.ActionSupport;

import cn.ethan.ognl.entity.User;

public class ValueStackAction extends ActionSupport{
	
	//private String username;
	private User user = new User();
	
//	public String getUsername() {
//		return username;
//	}

	@Override
	public String execute() throws Exception {
	//	username="kobe bryant";
		user.setAddress("zhongguo");
		user.setUsername("zhangsan");
		user.setPassword("123");
		
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}
}
