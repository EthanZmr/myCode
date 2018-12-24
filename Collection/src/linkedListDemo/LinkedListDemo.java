package linkedListDemo;

import java.util.LinkedList;

/*
 * linkedlist特有功能
 */
public class LinkedListDemo {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		list.add("Hello");
		list.add("World");
		list.add("Java");
		
		list.addFirst("First");
		list.addLast("Last");
		
		System.out.println("获取第一个 ：" + list.getFirst());
	}
}
