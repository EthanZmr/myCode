package arraylistDemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemo1 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("hello");
		list.add("world");
		list.add("java");
		
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}
	}
}
