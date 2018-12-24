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

public class RegistServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService userService = new UserService();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		/*String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);*/
		User user = CommonUtils.toBean(request.getParameterMap(), User.class);
		try {
			userService.regist(user);
			response.getWriter().print("<h1>注册成功</h1>");;
		} catch (UserException e) {
			request.setAttribute("message", e.getMessage());
			request.getRequestDispatcher("/resigt.jsp").forward(request, response);
		}
	}
}
