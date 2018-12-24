package linkedListDemo;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkListDemo {
	public static void main(String[] args) {
		LinkedList link = new LinkedList();
		
		link.addFirst("Hello");
		link.addFirst("World");
		link.addFirst("Java");
		
		Iterator it = link.iterator();
		while(it.hasNext()) {
			String str = (String) it.next();
			System.out.println(str);
		}
	}
}
