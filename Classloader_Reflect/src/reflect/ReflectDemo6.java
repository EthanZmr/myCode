package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/*
 * 根据反射获取成员方法并使用
 */
public class ReflectDemo6 {
	public static void main(String[] args) {
		try {
			Class c = Class.forName("reflect.Person");
			//获取自己的包括弗雷的公共方法
			//Method[] methods = c.getMethods();
//			Method[] methods = c.getDeclaredMethods();//获取自己类中的所有方法
//			for (Method method : methods) {
//				System.out.println(method);
//			}
			
			Constructor con = c.getConstructor();
			Object obj = con.newInstance();
			
			Method show = c.getMethod("show");
			show.invoke(obj);
			
			//调用带一个参数方法
			Method getString = c.getMethod("getString", String.class,int.class);
			Object objString = getString.invoke(obj, "zmr",40);
			System.out.println(objString);
			
			//调用私有属性方法
			Method function = c.getDeclaredMethod("function");
			function.setAccessible(true);
			function.invoke(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
