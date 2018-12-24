package file_demo;
/*
 * 波菲娜契数据  兔子数组
 */
public class RecursionDemo2 {
	public static void main(String[] args) {
		int[] arr = new int[20];
		arr[0] = 1;
		arr[1] = 1;
		
		for (int i = 2; i < arr.length; i++) {
			arr[i] = arr[i-2] + arr[i-1];
		}
		System.out.println(arr[19]);
		
		System.out.println("---------------------------");
		
		int a = 1;
		int b = 1;
		for (int i = 0; i < 18; i++) {
			int tem = a;
			a = b;
			b = tem + b;
		}
		System.out.println(b);
		System.out.println("---------------------------");
		System.out.println(sum(20));
	}
	
	public static int sum(int num) {
		if(num == 1||num == 2) {
			return 1;
		} else {
			return sum(num - 1) + sum(num - 2); 
		}
	}
}
