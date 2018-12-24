package com.ethan.role_user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		
		if(username.contains("itcast")) {
			req.getSession().setAttribute("admin", username);
		} else {
			req.getSession().setAttribute("username", username);
		}
		
		req.getRequestDispatcher("/a.jsp").forward(req, resp);
	}
}
