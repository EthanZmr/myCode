package file_demo;

import java.io.File;

/*
 * 获取指定目录下所有的java结尾的文件的绝对路径输出在控制台
 */
public class RecursionDemo3 {
	public static void main(String[] args) {
		File file = new File("/Users/ethan/Documents/demo");
		
		allJavaFile(file);
	}

	private static void allJavaFile(File file) {
		File[] fileArray = file.listFiles();
		
		for (File eachFile : fileArray) {
			if(eachFile.isDirectory()) {
				allJavaFile(eachFile);
			} else {
				if(eachFile.getName().endsWith(".java")) {
					System.out.println(eachFile.getAbsolutePath());
				}
			}
		}
	}
}
