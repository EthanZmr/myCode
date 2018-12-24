package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * 通过反射获取成员变量并使用
 * @author ethan
 *
 */
public class ReflectDemo5 {
	public static void main(String[] args) {
		try {
			Class c = Class.forName("reflect.Person");
			
			//获取所有的成员变量
			//Filed[] fileds = c.getFileds();
			Field[] fields = c.getDeclaredFields();
			for (Field field : fields) {
				System.out.println(field);
			}
			System.out.println("============================");
			//获取单个成员变量
			//获取address并对其赋值
			//通过无参构造器方法创建对象
			Constructor con = c.getConstructor();
			Object obj = con.newInstance();
			
			Field addressField = c.getDeclaredField("address");
			addressField.set(obj, "广州");;
			
			Field nameField = c.getDeclaredField("name");
			nameField.setAccessible(true);
			nameField.set(obj, "张梦然");
			
			System.out.println(obj);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
