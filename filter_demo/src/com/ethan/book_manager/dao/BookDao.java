package com.ethan.book_manager.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.ethan.book_manager.domain.Book;

import cn.itcast.jdbc.TxQueryRunner;

public class BookDao {
	private QueryRunner qr = new TxQueryRunner();
	
	public List<Book> findAll() throws SQLException{
		String sql = "select * from t_book";
		List<Book> list = qr.query(sql, new BeanListHandler<Book>(Book.class));
		return list;
	}
	
	public List<Book> findByCategory(int category) throws SQLException{
		String sql = "select * from t_book where category=?";
		List<Book> list = qr.query(sql, new BeanListHandler<Book>(Book.class),category);
		return list;
	}
}
