package io_demo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo2 {
	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("/Users/ethan/Documents/demo/fos.txt");
			fos.write(97);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
