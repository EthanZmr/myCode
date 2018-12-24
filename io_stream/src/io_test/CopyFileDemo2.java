package io_test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileDemo2 {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream("/Users/ethan/Documents/demo/fos.txt");
			fos = new FileOutputStream("/Users/ethan/Documents/demo2/copyFos.txt");
			int bytes = 0;
			while((bytes = fis.read()) != -1) {
				fos.write(bytes);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fis != null&&fos != null) {
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
