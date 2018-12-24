package file_demo;

import java.io.File;
import java.io.FilenameFilter;

/*
 * 判断指定目录下是否有后缀名为.jpg的文件，如果有就输出次文件名称
 * 获取的时候就已经是满足条件的了，然后输出即可
 * FilenameFilter:文件名称过滤器
 */
public class FileDemo4 {
	public static void main(String[] args) {
		File file = new File("/Users/ethan/Documents/demo");
		
		String[] strArray = file.list(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				return new File(dir,name).isFile()&&name.endsWith(".jpg");
			}
		});
		
		for (String string : strArray) {
			System.out.println(string);
		}
	}
}
