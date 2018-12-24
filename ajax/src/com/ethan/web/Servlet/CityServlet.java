package com.ethan.web.Servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * Servlet implementation class CityServlet
 */
@WebServlet("/CityServlet")
public class CityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/xml;charset=utf-8");
		/*
		 * 获取省份元素，加载该省份对应的<province>元素！
		 * 把元素转换成字符串发送给客户端
		 * 
		 * 1.获取省份名称
		 * 2.使用省份名称查找对应的<province>元素
		 * 3.把<province>元素转换成字符串，发送！
		 */
		try {
			SAXReader reader = new SAXReader();
			InputStream input = this.getClass().getResourceAsStream("/china.xml");
			Document document = reader.read(input);
			
			String pname = request.getParameter("pname");
			Element proEle = (Element) document.selectSingleNode("//province[@name='" + pname + "']");
			String xmlStr = proEle.asXML();
			response.getWriter().print(xmlStr);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		
	}

}