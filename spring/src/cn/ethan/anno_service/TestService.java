package cn.ethan.anno_service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestService {
	@Test
	public void testAccount() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
		OrdersService service = (OrdersService) context.getBean("ordersService");
		service.transferAccount("小王", "小马");
	}
}
