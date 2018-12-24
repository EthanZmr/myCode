package reflect;

import java.lang.reflect.Constructor;

/*
 * 通过反射获取私有构造方法并使用
 */
public class ReflectDemo4 {
	public static void main(String[] args) {
		try {
			//获取字节码文件对象
			Class c = Class.forName("reflect.Person");
			//获取私有构造方法对象
			Constructor con = c.getDeclaredConstructor(String.class);
			con.setAccessible(true);
			//用该私有构造方法创建对象
			Object obj = con.newInstance("帅哥");
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
