package cn.ethan.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.ethan.model.Customer;
import cn.ethan.service.CustomerService;
import cn.ethan.service.impl.CustomerServiceImpl;

public class CustomerAction extends ActionSupport{
	
	private List<Customer> list;
	
	public List<Customer> getList() {
		return list;
	}

	//客户列表
	public String list() {
		CustomerService service = new CustomerServiceImpl();
		//List<Customer> list = service.findAll();
		
		//放到域对象中
		//HttpServletRequest request = ServletActionContext.getRequest();
		//request.setAttribute("list", list);
		list = service.findAll();
		
		return "list";
	}
	
	//登录
	public String login() {
		//得到request对象
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username.equals("zhangsan")&&password.equals("250")) {
			request.getSession().setAttribute("user", username);
			return "loginSuccess";
		}else{
			return "loginFailed";
		}
	}
}
