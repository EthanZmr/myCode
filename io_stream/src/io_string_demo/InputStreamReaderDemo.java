package io_string_demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderDemo {
	public static void main(String[] args) {
		InputStreamReader isr = null;
		
		try {
			isr = new InputStreamReader(new FileInputStream("/Users/ethan/Documents/demo/fos.txt"),"utf-8");
			
			char[] chs = new char[1024];
			int ch = 0;
			while((ch = isr.read(chs)) != -1) {
				System.out.println(new String(chs,0,ch));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(isr != null) isr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
