package com.ethan.cstm.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ethan.cstm.domain.Customer;
import com.ethan.cstm.service.CustomerService;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;

public class CustomerServlet extends BaseServlet{
	
	private CustomerService customerService = new CustomerService();
	
	public String add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * 封装表单数据
		 */
		Customer c = CommonUtils.toBean(req.getParameterMap(), Customer.class);
		c.setCid(CommonUtils.uuid());
		try {
			customerService.add(c);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		req.setAttribute("msg", "添加成功");
		return "f:/msg.jsp";
	}
	
	public String query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			List<Customer> list = customerService.findAll();
			req.setAttribute("list", list);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return "f:/list.jsp";
	}
	
	public String preEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cid = req.getParameter("cid");
		try {
			Customer cstm = customerService.findByCid(cid);
			req.setAttribute("cstm", cstm);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return "f:/edit.jsp";
	}
	
	public String edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Customer cstm = CommonUtils.toBean(req.getParameterMap(), Customer.class);
		try {
			customerService.edit(cstm);
			req.setAttribute("msg", "修改成功");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return "f:/msg.jsp";
	}
	
	public String delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cid = req.getParameter("cid");
		try {
			customerService.delete(cid);
			req.setAttribute("msg", "删除成功");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return "f:/msg.jsp";
	}
	
	public String search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Customer customer = CommonUtils.toBean(req.getParameterMap(), Customer.class);
		try {
			List<Customer> list = customerService.search(customer);
			req.setAttribute("list", list);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return "f:/list.jsp";
	}
}
