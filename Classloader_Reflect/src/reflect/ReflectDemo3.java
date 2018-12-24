package reflect;

import java.lang.reflect.Constructor;

/*
 * 通过反射去获取构造方法并使用
 */
public class ReflectDemo3 {
	public static void main(String[] args) {
		try {
			Class c = Class.forName("reflect.Person");
			//获取带参构造器
			Constructor con = c.getConstructor(String.class,int.class,String.class);
			Object obj = con.newInstance("林青霞",27,"北京");
			System.out.println(obj);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
