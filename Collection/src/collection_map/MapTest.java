package collection_map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest {
	public static void main(String[] args) {
		String str = "gasgwdgadghjijhkhh";
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		char[] ch = str.toCharArray();
		for (char key : ch) {
			Integer value = map.get(key);
			if(map.get(key) == null) {
				map.put(key, 1);
			}else {
				value++;
				map.put(key, value);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		Set<Character> set = map.keySet();
		for (Character key : set) {
			Integer value = map.get(key);
			sb.append(key).append("(").append(value).append(")");
		}
		
		String result = sb.toString();
		System.out.println(result);
	}
}
