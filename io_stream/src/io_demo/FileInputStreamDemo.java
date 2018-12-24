package io_demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamDemo {
	public static void main(String[] args) {
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("/Users/ethan/Documents/demo/ItemsController3.java");
			int bytes = 0;
			while((bytes = fis.read()) != -1) {
				System.out.print((char)bytes);
			}
		} catch (FileNotFoundException e) {	
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
