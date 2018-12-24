package io_test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 复制文本文件
 * @author ethan
 *
 */
public class CopyFileDemo {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream("/Users/ethan/Documents/demo/fos.txt");
			fos = new FileOutputStream("/Users/ethan/Documents/demo2/copy_fos.txt");
			byte[] bytes = new byte[1024];
			int len = 0;
			while((len = fis.read(bytes)) != -1) {
				fos.write(bytes, 0, len);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fis!=null&&fos!=null) {
				try {
					fis.close();
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
