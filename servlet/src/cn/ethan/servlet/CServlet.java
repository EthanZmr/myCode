package cn.ethan.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext application = this.getServletContext();
		String name = (String) application.getAttribute("name");
		System.out.println(name);
		String path = this.getServletContext().getRealPath("");
		InputStream is = this.getServletContext().getResourceAsStream("");
		
		
	}
}
