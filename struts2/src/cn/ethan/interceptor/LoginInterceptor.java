package cn.ethan.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * 自定义登录拦截器
 * 	需求：
 * 		在项目中，有很多action的超链接，实现只有是登录的状态，
 * 		才可以点击action的超链接功能，如果不是登录状态，
 * 		点击action超链接返回到登录也看
 * 
 * 登录的状态：使用session域对象实现
 * 	1.登录成功之后，把数据放到session里面
 * 	2.判断session是否有值，可以知道是否是登录状态
 * 
 * 
 * @author ethan
 *
 */
public class LoginInterceptor extends MethodFilterInterceptor{
	//完成拦截器逻辑
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		Object obj = request.getSession().getAttribute("username");
		if(obj != null) {
			return invocation.invoke();
		}else {
			//到result标签中 这都熬名称是返回值的值，到配置路径中去
			return "loginFailed";
		}
	}

}
