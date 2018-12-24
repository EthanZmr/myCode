package reflect_Arraylist;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class ArrayListDemo {
	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<Integer>();
		Class c = array.getClass();
		try {
			Method add = c.getMethod("add", Object.class);
			add.invoke(array, "hello");
			add.invoke(array, "world");
			
			System.out.println(array);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
