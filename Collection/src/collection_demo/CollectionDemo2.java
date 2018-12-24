package collection_demo;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo2 {
	public static void main(String[] args) {
		Collection col = new ArrayList();
		
		col.add("abc1");
		col.add("abc2");
		
		Collection col2 = new ArrayList();
		
		col2.add("abc3");
		col2.add("abc4");
		
		System.out.println("addAll:" + col.addAll(col2));
		
		System.out.println("removeAll:" + col.removeAll(col2));
		
		
	}
}
