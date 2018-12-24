package linkedListDemo;

import java.util.LinkedList;

/**
 * LinkedList模拟栈数据的集合
 * @author ethan
 *
 */
public class MyStack {
	private LinkedList link = null;
	
	public MyStack() {
		link = new LinkedList();
	}
	
	public void add(Object object) {
		link.addFirst(object);
	}
	
	public Object get() {
		return link.removeFirst();
	}
	
	public boolean isEmpty() {
		return link.isEmpty();
	}
}
