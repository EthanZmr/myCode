package collection_demo;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo {
	public static void main(String[] args) {
		Collection col = new ArrayList();
		
		col.add("Hello");
		col.add("World");
		col.add("java");
		
		System.out.println("add:" + col.add("Hello"));
		System.out.println("remove:" + col.remove("Hello"));
		System.out.println("contains:" + col.contains("Hello"));
		System.err.println("isEmpty:" + col.isEmpty());
	}
}
