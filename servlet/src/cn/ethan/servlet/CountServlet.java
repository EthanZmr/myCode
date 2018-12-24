package cn.ethan.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CountServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext application = this.getServletContext();
		Integer count = (Integer) application.getAttribute("count");
		if(count == null) {
			application.setAttribute("count", 1);
		}else {
			application.setAttribute("name", count++);
		}
		Integer counts = (Integer)application.getAttribute("count");
		resp.getWriter().print("<h1>访问了" + counts + "次</h1>");
	}
}
