package cn.ethan.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyBook {
	public void before1() {
		System.out.println("前置增强");
	}
	
	public void after() {
		System.out.println("后置增强");
	}
	
	public void around(ProceedingJoinPoint pjp) {
		//方法之前
		System.out.println("现在是方法执行之前");
		
		//执行被增强的方法
		try {
			pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		//方法之后
		System.out.println("现在是方法执行之后");
	}
}
