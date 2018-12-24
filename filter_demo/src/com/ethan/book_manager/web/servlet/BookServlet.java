package com.ethan.book_manager.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ethan.book_manager.service.BookService;

import cn.itcast.servlet.BaseServlet;

public class BookServlet extends BaseServlet{
	
	private BookService bookService = new BookService();
	
	public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("bookList", bookService.findAll());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "f:/show_book.jsp";
	}
	
	public String findByCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value = request.getParameter("category");
		int category = Integer.parseInt(value);
		try {
			request.setAttribute("bookList", bookService.findByCategory(category));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "f:/show_book.jsp";
	}
}
