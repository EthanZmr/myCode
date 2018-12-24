package cn.ethan.demo;

import org.junit.Test;

public class Demo {
	public static void main(String[] args) {
		System.out.println(getSum(1,5));
	}
	public static int getSum(int a,int count) {
		int sum = 0;
		int num = a;
		for (int i = 1; i <= count; i++) {
			sum += num;
			num = num*10 + a;
		}
		return sum;
	}
}
