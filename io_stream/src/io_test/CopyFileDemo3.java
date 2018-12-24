package io_test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileDemo3 {
	public static void main(String[] args) {
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(new FileInputStream("/Users/ethan/Documents/demo/面试题.pages"));
			bos = new BufferedOutputStream(new FileOutputStream("/Users/ethan/Documents/demo2/面试题.pages"));
			
			byte[] bytes = new byte[1024];
			int len = 0;
			while((len = bis.read(bytes)) != -1) {
				bos.write(bytes, 0, len);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(bis != null&&bos != null) {
				try {
					bis.close();
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
