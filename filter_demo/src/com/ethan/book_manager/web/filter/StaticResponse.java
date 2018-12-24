package com.ethan.book_manager.web.filter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class StaticResponse extends HttpServletResponseWrapper{
	
	private HttpServletResponse resp;
	
	private PrintWriter pw;

	public StaticResponse(HttpServletResponse response, String path) throws FileNotFoundException, UnsupportedEncodingException {
		super(response);
		this.resp = response;
		pw = new PrintWriter(path, "utf-8");
	}
	
	public PrintWriter getWriter() throws IOException {
		//返回一个与html绑定在一起的printWriter对象
		return pw;
	}
}
