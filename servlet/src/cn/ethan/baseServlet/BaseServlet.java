package cn.ethan.baseServlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * 1.获取参数，用来识别用户想请求的方法
		 * 2.然后判断是哪一个方法，是哪个就调用哪个
		 */
		String methodName = req.getParameter("method");
		
		if(methodName == null||methodName.trim().isEmpty()) {
			throw new RuntimeException("没method参数");
		}
		/*
		 * 得到方法名称，是否可通过反射来调用方法？
		 * 1.得到方法名，通过方法名得到method类的对象
		 * 		*需要得到class，然后调用它的方法进行查询，得到method
		 * 		*我们要查询的是当前类的方法，所以我们需要得到当前类的class
		 */
		Class c = this.getClass();
		Method method = null;
		try {
			method = c.getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		/*
		 * 调用method表示的方法
		 */
		try {
			String result = (String)method.invoke(this, req,resp);
			/*
			 * 获取请求方法执行后返回的字符串，它表示转发或者重定向的路径！
			 * 帮它完成转发或者重定向
			 * 如果用户返回的字符串为null，或者为“” 那么我们什么也不做
			 * 
			 */
			if(result == null||result.trim().isEmpty()) {
				return;
			}
			/*
			 * 查看返回的字符串中是否包含冒号，如果没有表示转发
			 * 如果有，使用冒号分割字符串，得到前缀和后缀
			 * 其中前缀如果是F，表示转发，如果是r表示重定向，后缀就是要转发或者重定向的路径了
			 */
			if(result.contains(":")) {
				//使用冒号分割字符串得到前缀和后缀
				int index = result.indexOf(":");
				String pre = result.substring(0, index);
				String path = result.substring(index+1);
				if(pre.equalsIgnoreCase("r")) {
					resp.sendRedirect(req.getContextPath()+path);
				}else if(pre.equalsIgnoreCase("f")) {
					req.getRequestDispatcher(path).forward(req, resp);
				}else {
					throw new RuntimeException("指令错误");
				}
			}else {
				req.getRequestDispatcher(result).forward(req, resp);
			}
			
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}
}
