package file_demo2;

import java.io.File;
import java.io.IOException;

public class FileDemo {
	public static void main(String[] args) {
		//封装目录
		File file = new File("/Users/ethan/Documents/demo/newDemo");
		//创建文件夹
		file.mkdir();
		File file2 = new File(file,"fos.txt");
		try {
			file2.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
