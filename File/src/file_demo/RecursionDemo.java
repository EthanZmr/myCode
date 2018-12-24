package file_demo;
/*
 * 方法定义中，调用方法本省的现象叫做递归
 */
public class RecursionDemo {
	public static void main(String[] args) {
		System.out.println(jc(10));
	}
	public static int jc(int num) {
		if(num > 1) {
			return num * jc(num-1);
		}else {
			return 1;
		}
	}
}
