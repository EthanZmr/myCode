package com.ethan.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
/**
 * 可以在这个监听器存放一些在tomcat启动时就要完成的代码（第一次惩罚）
 * @author ethan
 *
 */
public class AListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("我要死了");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("我出生了");
	}

}