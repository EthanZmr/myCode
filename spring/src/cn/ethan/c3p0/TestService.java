package cn.ethan.c3p0;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestService {
	@Test
	public void testAdd() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		UserService service = (UserService) context.getBean("service");
		service.add();
	}
}
