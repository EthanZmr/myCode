package file_demo;

import java.io.File;
import java.io.IOException;

/*
 * 创建功能：
 * 		boolean createNewFile(); 创建文件 如果存在就不创建了
 * 		boolean mkdir(); 创建文件夹 如果存在就不创建了
 * 		boolean mkdirs(); 创建文件夹 如果父文件夹不存在，会自动创建出来
 */
public class FileDemo2 {
	public static void main(String[] args) {
		//在目录下创建一个文件夹demo
		File file = new File("/Users//ethan/Documents/demo");
		System.out.println(file.mkdir());
		
		//在demo下创建一个文件a.txt
		File file2 = new File("/Users/ethan/Documents/demo/a.txt");
		try {
			System.out.println(file2.createNewFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		File file3 = new File("/Users/ethan/Documents/demo2/demo3");
		System.out.println(file3.mkdirs());
	}
}
