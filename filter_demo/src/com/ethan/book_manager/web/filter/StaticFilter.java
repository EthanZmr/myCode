package com.ethan.book_manager.web.filter;

import java.io.File;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class StaticFilter
 */
@WebFilter(servletNames = { "bookServlet" })
public class StaticFilter implements Filter {
	
	private FilterConfig config;

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		/*
		 * 1.第一次访问时，查找请求对应的html页面是否存在，如果存在重定向到html
		 * 2.如果不存在，放行， 把servlet访问数据库后，输出给客户端的数据保存到一个html文件中再重定向到html
		 */
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		//1.获取category参数
		String category = request.getParameter("category");
		String htmlPage = category + ".html";
		String htmlPath = config.getServletContext().getRealPath("/htmls"); //得到文件的存放目录
		File destFile = new File(htmlPath, htmlPage);
		
		if(destFile.exists()) {
			resp.sendRedirect(req.getContextPath() + "/htmls/" + htmlPage);
			return;
		}
		
		//2.如果html文件不存在，我们要生成html
		//2-1.放行，show.jsp会做出很多的输出，我们要让它别再输出给客户端，而是输出到我们指定的一个html文件中
		//调包response，让它的getWriter()与一个html文件绑定，那么show.jsp的输出就到html文件中了
		
		StaticResponse sr = new StaticResponse(resp, destFile.getAbsolutePath());
		
		chain.doFilter(request, sr);
		resp.sendRedirect(req.getContextPath() + "/htmls/" + htmlPage);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		this.config = fConfig;
	}

}
