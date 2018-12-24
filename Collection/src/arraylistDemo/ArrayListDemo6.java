package arraylistDemo;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * 去除集合中重复的自定义对象
 */
public class ArrayListDemo6 {
	public static void main(String[] args) {
		ArrayList array = new ArrayList();
		
		Student s1 = new Student("林青霞",27);
		Student s2 = new Student("林志玲",40);
		Student s3 = new Student("凤姐",35);
		Student s4 = new Student("芙蓉姐姐",18);
		Student s5 = new Student("翠花",16);
		Student s6 = new Student("林青霞",27);
		Student s7 = new Student("林志玲",25);
		Student s8 = new Student("林青霞",18);
		Student s9 = new Student("林志玲",40);
		
		array.add(s1);
		array.add(s2);
		array.add(s3);
		array.add(s4);
		array.add(s5);
		array.add(s6);
		array.add(s7);
		array.add(s8);
		array.add(s9);
		
		ArrayList array2 = new ArrayList();
		
		Iterator it = array.iterator();
		while(it.hasNext()) {
			Student stu = (Student) it.next();
			if(!array2.contains(stu)) {
				array2.add(stu);
			}
		}
		
		for (int i = 0; i < array2.size(); i++) {
			Student stu = (Student) array2.get(i);
			System.out.println(stu);
			
		}
	}
}
