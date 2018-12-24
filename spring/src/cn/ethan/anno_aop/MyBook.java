package cn.ethan.anno_aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;


@Aspect
public class MyBook {
	
	//在方法上使用注解完成增强配置
	@Before(value="execution(* cn.ethan.anno_aop.Book.add(..))")
	public void before() {
		System.out.println("before...");
	}
}
