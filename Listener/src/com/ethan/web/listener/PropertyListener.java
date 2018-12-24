package com.ethan.web.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
/*
 * 属性监听器
 */
public class PropertyListener implements ServletContextAttributeListener{

	@Override
	public void attributeAdded(ServletContextAttributeEvent arg0) {
		System.out.println("添加了东西"+arg0.getName()+"东西叫"+arg0.getValue());
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent arg0) {
		System.out.println(arg0.getName() + "=" + arg0.getValue());
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent arg0) {
		System.out.println(arg0.getName() + "=" + arg0.getValue()+":"+arg0.getServletContext().getAttribute(arg0.getName()));
	}
	
}
