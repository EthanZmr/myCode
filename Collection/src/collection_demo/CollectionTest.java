package collection_demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionTest {
	public static void main(String[] args) {
		Collection col = new ArrayList();
		
		col.add("Hello");
		col.add("World");
		col.add("java");
		
		Iterator it = col.iterator();
		while(it.hasNext()) {
			String s = (String) it.next();
			System.out.println(s);
		}
	}
}
