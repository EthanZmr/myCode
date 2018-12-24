package arraylistDemo;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo2 {
	public static void main(String[] args) {
		ArrayList array = new ArrayList();
		
		Student s1 = new Student("张三",20);
		Student s2 = new Student("李四",22);
		Student s3 = new Student("王五",35);
		Student s4 = new Student("赵六",26);
		
		array.add(s1);
		array.add(s2);
		array.add(s3);
		array.add(s4);
		
		Iterator it = array.iterator();
		while(it.hasNext()) {
			Student stu = (Student) it.next();
			System.out.println(stu);
		}
		
	}
}
