package arraylistDemo;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * ArrayList的使用
 */
public class ArrayListDemo {
	public static void main(String[] args) {
		ArrayList array = new ArrayList();
		
		array.add("hello");
		array.add("world");
		array.add("java");
		
		Iterator it = array.iterator();
		while(it.hasNext()) {
			String s = (String) it.next();
			System.out.println(s);
		}
		
		System.out.println("------------------");
		for (int i = 0; i < array.size(); i++) {
			String s = (String) array.get(i);
			System.out.println(s);
		}
	}
}
