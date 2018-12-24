package collection_demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import arraylistDemo.Student;

public class CollectionTest2 {
	public static void main(String[] args) {
		Collection col = new ArrayList();
		
		Student s1 = new Student("张三",28);
		Student s2 = new Student("李四",26);
		Student s3 = new Student("王五",24);
		Student s4 = new Student("赵六",22);
		
		col.add(s1);
		col.add(s2);
		col.add(s3);
		col.add(s4);
		
		Iterator it = col.iterator();
		while(it.hasNext()) {
			Student stu = (Student) it.next();
			System.out.println(stu);
		}
	}
}
