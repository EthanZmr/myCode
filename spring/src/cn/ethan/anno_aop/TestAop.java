package cn.ethan.anno_aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {
	@Test
	public void testAnnoDemo() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Book book = (Book) context.getBean("book");
		book.add();
	}
}
