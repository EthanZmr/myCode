package cn.ethan.ognl.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class UserAction extends ActionSupport{
	@Override
	public String execute() throws Exception {
		ActionContext ac = ActionContext.getContext();
		ValueStack vs = ac.getValueStack();
		
		ValueStack vs2 = ac.getValueStack();
		
		System.out.println(vs == vs2); //true
		return NONE;
	}
}
