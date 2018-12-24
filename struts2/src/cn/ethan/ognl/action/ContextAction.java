package cn.ethan.ognl.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class ContextAction extends ActionSupport{
	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("req", "reqValue");
		return SUCCESS;
	}
}
