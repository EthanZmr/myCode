package arraylistDemo;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * 去除集合中字符串的重复值 
 */
public class ArrayListDemo3 {
	public static void main(String[] args) {
		ArrayList array = new ArrayList();
		
		ArrayList array2 = new ArrayList();
		
		array.add("Hello");
		array.add("World");
		array.add("java");
		array.add("World");
		array.add("java");
		
		Iterator it = array.iterator();
		while(it.hasNext()) {
			String s = (String) it.next();
			if(!array2.contains(s)) {
				array2.add(s);
			}
		}
		
		for (int i = 0; i < array2.size(); i++) {
			String s = (String) array2.get(i);
			System.out.println(s);
		}
	}
}
