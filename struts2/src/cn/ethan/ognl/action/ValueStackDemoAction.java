package cn.ethan.ognl.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class ValueStackDemoAction extends ActionSupport{
	
//	private String name;
//	
//	public String getName() {
//		return name;
//	}

	@Override
	public String execute() throws Exception {
		//使用值栈对象中的set方法
		ActionContext ac = ActionContext.getContext();
		ValueStack vs = ac.getValueStack();
//		vs.set("username", "kobe bryant");  
		vs.push("abcd");
		//name="kobe";
		
		return SUCCESS;
	}
}
