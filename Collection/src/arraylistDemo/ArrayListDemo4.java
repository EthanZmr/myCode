package arraylistDemo;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * 冒泡排序算法
 */
public class ArrayListDemo4 {
	public static void main(String[] args) {
		ArrayList array = new ArrayList();
		
		array.add("hello");
		array.add("world");
		array.add("java");
		array.add("java");
		array.add("world");
		array.add("java");
		
		for (int i = 0; i < array.size()-1; i++) {
			for (int j = i+1; j < array.size(); j++) {
				if(array.get(i).equals(array.get(j))) {
					array.remove(j);
					j--;
				}
			}
		}
		
		Iterator it = array.iterator();
		while(it.hasNext()) {
			String s = (String) it.next();
			System.out.println(s);
		}
	}
}
