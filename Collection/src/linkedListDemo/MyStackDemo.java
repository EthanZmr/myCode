package linkedListDemo;


public class MyStackDemo {
	public static void main(String[] args) {
		MyStack ms = new MyStack();
		
		ms.add("Hello");
		ms.add("World");
		ms.add("Java");
		
		while(!ms.isEmpty()) {
			System.out.println(ms.get());
		}
	}
}
