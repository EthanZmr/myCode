package com.ethan.ip_demo;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class AListener
 *
 */
public class AListener implements ServletContextListener {

	
    public void contextDestroyed(ServletContextEvent sce)  { 
    	
    }


    public void contextInitialized(ServletContextEvent sce)  { 
    	
    	Map<String, Integer> map = new LinkedHashMap<String, Integer>();
    	
    	ServletContext application = sce.getServletContext();
    	
    	application.setAttribute("map", map);
    }
	
}
