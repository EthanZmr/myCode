package cn.ethan.ognl.valuestack;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import cn.ethan.ognl.entity.User;

public class ObjectValueStackAction extends ActionSupport{
	private List<User> list = new ArrayList<User>();
	
	public List<User> getList() {
		return list;
	}

	@Override
	public String execute() throws Exception {
		User user1 = new User();
		user1.setUsername("张三");
		user1.setPassword("123");
		user1.setAddress("中国");
		
		User user2 = new User();
		user2.setUsername("李四");
		user2.setPassword("456");
		user2.setAddress("美国");
		
		list.add(user1);
		list.add(user2);
		return SUCCESS;
	}
}
