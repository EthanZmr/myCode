package hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import arraylistDemo.Student;

public class HashMapSaveObject {
	public static void main(String[] args) {
		Map<String, Student> map = new HashMap<String,Student>();
		
		Student s1 = new Student("zhangsan",27);
		Student s2 = new Student("lisi",29);
		Student s3 = new Student("wangwu",31);
		
		map.put("1", s1);
		map.put("2", s2);
		map.put("3", s3);
		
		Set<String> set = map.keySet();
		for (String key : set) {
			Student value = map.get(key);
			System.out.println(key+"="+value);
		}
		
		
	}
}
