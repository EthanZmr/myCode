package cn.ethan.ognl.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class ListDemoAction extends ActionSupport{
	
	private List<String> list;
	
	
	public List<String> getList() {
		return list;
	}


	@Override
	public String execute() throws Exception {
		list = new ArrayList<String>();
		
		list.add("Hello");
		list.add("world");
		list.add("java");
		return SUCCESS;
	}
}
