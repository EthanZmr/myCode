package com.ethan.role_user;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class UserFilter
 */
@WebFilter("/users/*")
public class UserFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		/*
		 * 1.得到session
		 * 2.判断session中是否存在admin，如果存在，放行
		 * 3.判断session中是否存在username，如果存在，放行 否则回退到login.jsp
		 * 
		 */
		HttpServletRequest req = (HttpServletRequest) request;
		String name = (String) req.getSession().getAttribute("admin");
		if(name != null) {
			chain.doFilter(request, response);
			return;
		} 
		name = (String) req.getSession().getAttribute("username");
		if(name != null) {
			chain.doFilter(request, response);
		} else {
			request.setAttribute("msg", "滚犊子");
			req.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
