package file_demo;

import java.io.File;

/*
 * 判断E盘目录下是否有后缀名为.jpg的文件，如果有，就输出此文件名称
 */
public class FileDemo3 {
	public static void main(String[] args) {
		File file = new File("/Users/ethan/Documents/demo");
		
		File[] fileArray = file.listFiles();
		for (File thisFile : fileArray) {
			if(thisFile.isFile()) {
				if(thisFile.getName().endsWith(".jpg")) {
					System.out.println(thisFile.getName());
				}
			}
		}
	}
}
