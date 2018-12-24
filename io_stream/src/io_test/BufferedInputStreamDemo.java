package io_test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferedInputStreamDemo {
	public static void main(String[] args) {
		BufferedInputStream bis = null;
		try {
			bis = new BufferedInputStream(new FileInputStream("/Users/ethan/Documents/demo/面试题.pages"));
			
			byte[] bytes = new byte[1024];
			int len = 0;
			while((len = bis.read(bytes)) != -1) {
				System.out.print(new String(bytes));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
