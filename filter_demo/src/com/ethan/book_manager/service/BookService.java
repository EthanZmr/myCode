package com.ethan.book_manager.service;

import java.sql.SQLException;
import java.util.List;

import com.ethan.book_manager.dao.BookDao;
import com.ethan.book_manager.domain.Book;

public class BookService {
	private BookDao bookDao = new BookDao();
	public List<Book> findAll() throws SQLException{
		return bookDao.findAll();
	}
	
	public List<Book> findByCategory(int category) throws SQLException{
		return bookDao.findByCategory(category);
	}
}
