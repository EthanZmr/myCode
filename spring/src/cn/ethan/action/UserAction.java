package cn.ethan.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.ethan.service.UserService;

public class UserAction extends ActionSupport{
	@Override
	public String execute() throws Exception {
		System.out.println("action......");
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		UserService userService = (UserService) context.getBean("userService");
		userService.add();
		return NONE;
	}
}
