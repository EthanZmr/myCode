package reflect;

import java.lang.reflect.Constructor;

/*
 * 通过反射获取构造方法并使用
 */
public class ReflectDemo2 {
	public static void main(String[] args) {
		try {
			Class c = Class.forName("reflect.Person");
			//获取构造方法
			Constructor[] cons = c.getConstructors();
			
			for (Constructor constructor : cons) {
				System.out.println(constructor);
			}
			System.out.println("=============================");
			Constructor[] cons2 = c.getDeclaredConstructors();
			
			for (Constructor constructor : cons2) {
				System.out.println(constructor);
			}
			
			System.out.println("==============================");
			
			//获取单个构造方法
			Constructor scon = c.getConstructor();
			Object obj = scon.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
