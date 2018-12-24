package io_demo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo3 {
	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("/Users/ethan/Documents/demo/fos2.txt",true);
			
			for (int i = 0; i < 10; i++) {
				fos.write(("hello" + i).getBytes());
				fos.write("\r".getBytes());
			}
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
