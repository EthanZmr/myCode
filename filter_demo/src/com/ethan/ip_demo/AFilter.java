package com.ethan.ip_demo;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class AFilter
 * 从application中获取map
 * 从request中得到当前客户端的ip
 * 进行统计工作，结果保存到map中
 */
public class AFilter implements Filter {
	private FilterConfig config;

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		Map<String, Integer> map = (Map<String, Integer>) config.getServletContext().getAttribute("map");
		
		String ip = request.getRemoteAddr();
		
		if(map.containsKey(ip)) {
			int cnt = map.get(ip);
			map.put(ip, cnt+1);
		} else {
			map.put(ip, 1);
		}
		config.getServletContext().setAttribute("map", map);
		
		chain.doFilter(request, response);
	}
	
	
	public void init(FilterConfig fConfig) throws ServletException {
		this.config = fConfig;
	}

}