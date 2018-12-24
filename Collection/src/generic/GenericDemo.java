package generic;

import java.util.ArrayList;
import java.util.Collection;

/*
 * 泛型高级（通配符）
 * ？：
 * ？extends E:
 * ? super E:
 */
public class GenericDemo {
	public static void main(String[] args) {
		//右边可以是任意引用类型
		Collection<?> c1 = new ArrayList<Object>();
		Collection<?> c2 = new ArrayList<String>();
		Collection<?> c3 = new ArrayList<Integer>();
		
		//右边类型必须是animal及其子类
		Collection<? extends Animal> c4 = new ArrayList<Animal>();
		Collection<? extends Animal> c5 = new ArrayList<Dog>();
		Collection<? extends Animal> c6 = new ArrayList<Cat>();
		
	}
}
class Animal{
	
}
class Dog extends Animal{
	
}
class Cat extends Animal{
	
}
