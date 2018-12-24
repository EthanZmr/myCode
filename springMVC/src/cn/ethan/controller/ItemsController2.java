package cn.ethan.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;
import org.springframework.web.servlet.ModelAndView;

import cn.ethan.model.Items;

/*
 * 商品处理器
 */
public class ItemsController2 implements HttpRequestHandler{

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//调用service查询数据库，查询商品列表，这里使用静态数据模拟
		List<Items> list = new ArrayList<Items>();
		Items items_1 = new Items();
		items_1.setName("联想笔记本");
		items_1.setPrice(6000f);
		items_1.setDetail("ThinkPad T430 联想笔记本！");
		
		Items items_2 = new Items();
		items_2.setName("苹果手机");
		items_2.setPrice(5000f);
		items_2.setDetail("iphone6苹果手机！");
		
		list.add(items_1);
		list.add(items_2);
		
		request.setAttribute("itemsList", list);
		//视图
		request.getRequestDispatcher("/WEB-INF/jsp/items/itemsList.jsp").forward(request, response);;
	}

/*	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//调用service查询数据库，查询商品列表，这里使用静态数据模拟
		List<Items> list = new ArrayList<Items>();
		Items items_1 = new Items();
		items_1.setName("联想笔记本");
		items_1.setPrice(6000f);
		items_1.setDetail("ThinkPad T430 联想笔记本！");
		
		Items items_2 = new Items();
		items_2.setName("苹果手机");
		items_2.setPrice(5000f);
		items_2.setDetail("iphone6苹果手机！");
		
		list.add(items_1);
		list.add(items_2);
		
		//创建modelAndView准备填充数据，设置视图
		ModelAndView modelAndView = new ModelAndView();
		//填充数据
		modelAndView.addObject("itemsList",list);
		//视图
		modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
		
		return modelAndView;
	}
 */
}
