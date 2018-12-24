package com.ethan.cstm.web.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ethan.cstm.domain.Customer;
import com.ethan.cstm.domain.PageBean;
import com.ethan.cstm.service.CustomerService;
import com.sun.media.jfxmedia.track.Track.Encoding;

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
//		try {
//			List<Customer> list = customerService.findAll();
//			req.setAttribute("list", list);
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//		return "f:/list.jsp";
		
		/*
		 * 1.获取页面传递的pageCode
		 * 2.给定pageSize值
		 * 3.使用pageCode 和 pageSize调用service方法，得到pageBean，保存到request域中
		 * 4.转发到list.jsp
		 */
		int pageCode = getPageCode(req);
		int pageSize = 10;
		try {
			PageBean<Customer> pb = customerService.findAll(pageCode, pageSize);
			pb.setUrl(getUrl(req));
			req.setAttribute("pb", pb);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "f:/list.jsp";
	}
	
	private int getPageCode(HttpServletRequest request) {
		String value = request.getParameter("pageCode");
		if(value == null || value.trim().isEmpty()) {
			return 1;
		}
		
		return Integer.parseInt(value);
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
//		Customer customer = CommonUtils.toBean(req.getParameterMap(), Customer.class);
//		try {
//			List<Customer> list = customerService.search(customer);
//			req.setAttribute("list", list);
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//		return "f:/list.jsp";
		/*
		 * 0.把条件封装到Customer对象中
		 * 1.得到pageCode
		 * 2.给定pageSize
		 * 3.使用pageCode和pageSize调用service方法得到pageBean
		 * 4.把pageBean保存到request域中
		 * 5.转发到list.jsp
		 */
		//获取查询条件
		Customer criteria = CommonUtils.toBean(req.getParameterMap(), Customer.class);
		
		/*
		 * 处理Get请求方式的编码问题
		 */
		criteria = encoding(criteria);
		
		int pageCode = getPageCode(req);
		int pageSize = 10;
		try {
			PageBean<Customer> pb = customerService.search(criteria,pageCode, pageSize);
			//得到url保存到pb中
			pb.setUrl(getUrl(req));
			req.setAttribute("pb", pb);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "f:/list.jsp";
	}
	
	private Customer encoding(Customer criteria) throws UnsupportedEncodingException {
		String cname = criteria.getCname();
		String gender = criteria.getGender();
		String cellphone = criteria.getCellphone();
		String email = criteria.getEmail();
		if(cname != null&&!cname.trim().isEmpty()) {
			cname = new String(cname.getBytes("ISO-8859-1"),"UTF-8");
			criteria.setCname(cname);
		}
		if(gender != null&&!gender.trim().isEmpty()) {
			gender = new String(gender.getBytes("ISO-8859-1"),"UTF-8");
			criteria.setGender(gender);
		}
		if(cellphone != null&&!cellphone.trim().isEmpty()) {
			cellphone = new String(cellphone.getBytes("ISO-8859-1"),"UTF-8");
			criteria.setCellphone(cellphone);
		}
		if(email != null&&!email.trim().isEmpty()) {
			email = new String(email.getBytes("ISO-8859-1"),"UTF-8");
			criteria.setEmail(email);
		}
		return criteria;
	}

	private String getUrl(HttpServletRequest request) {
		String contextPath = request.getContextPath();
		String servletPath = request.getServletPath();
		String queryString = request.getQueryString();
		if(queryString .contains("&pageCode=")) {
			int index = queryString.lastIndexOf("&pageCode=");
			queryString = queryString.substring(0, index);
		}
		return contextPath + servletPath + "?" + queryString;
	}
}