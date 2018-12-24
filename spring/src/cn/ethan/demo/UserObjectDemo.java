package cn.ethan.demo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.ethan.anno.BookService;
import cn.ethan.anno.ShopService;
import cn.ethan.aop.Book;
import cn.ethan.ioc.Bean2;
import cn.ethan.ioc.Bean3;
import cn.ethan.ioc.Preperty;
import cn.ethan.ioc.PropertyDemo;
import cn.ethan.ioc.User;
import cn.ethan.ioc.UserService;

public class UserObjectDemo {
	@Test
	public void testIoc() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		User user = (User)context.getBean("user");
		user.add();
	}
	
	@Test
	public void testStaticFactory() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Bean2 bean2 = (Bean2) context.getBean("bean2");
		bean2.add();
	}
	
	@Test
	public void testFactory() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Bean3 bean3 = (Bean3) context.getBean("bean3");
		bean3.add();
	}
	
	@Test
	public void testPreperty() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Preperty pro = (Preperty) context.getBean("preperty");
		pro.add();
	}
	
	@Test
	public void testBook() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		cn.ethan.ioc.Book book = (cn.ethan.ioc.Book) context.getBean("book");
		book.printBook();
	}
	
	@Test
	public void testServiceAndDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		UserService service = (UserService) context.getBean("userService");
		service.add();
	}
	
	@Test
	public void testPropertyDemo() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		PropertyDemo property = (PropertyDemo) context.getBean("propertyDemo");
		property.test1();
	}
	@Test
	public void testAnno() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		cn.ethan.anno.User user = (cn.ethan.anno.User) context.getBean("user2");
		user.add();
	}
	
	@Test
	public void testService() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		BookService bookService = (BookService) context.getBean("bookService");
		bookService.add();
	}
	
	@Test
	public void testShopService() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		ShopService shopService = (ShopService) context.getBean("shopService");
		shopService.add();
	}
	
	@Test
	public void testAop() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Book book = (Book) context.getBean("book");
		book.add();
	}
}
