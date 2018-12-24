package cn.ethan.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ethan.model.User;
import cn.ethan.service.UserException;
import cn.ethan.service.UserService;
import cn.itcast.commons.CommonUtils;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		UserService userService = new UserService();
		User user = CommonUtils.toBean(request.getParameterMap(), User.class);
		try {
			User _user = userService.login(user);
			request.setAttribute("username", _user.getUsername());
			request.setAttribute("password", _user.getPassword());
			request.getRequestDispatcher("/welcome.jsp").forward(request, response);
		} catch (UserException e) {
			request.setAttribute("message", e.getMessage());
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}
