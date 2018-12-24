package cn.ethan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String referer = req.getHeader("Referer");
		System.out.println(referer);
		
		if(referer == null || referer.contains("localhost")) {
			resp.sendRedirect("http://www.baidu.com");
		} else {
			System.out.println("没有人");
		}
	}
}
