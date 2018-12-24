package io_string_demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CopyFileDemo {
	public static void main(String[] args) {
		InputStreamReader isr = null;
		OutputStreamWriter osw = null;
		
		try {
			isr = new InputStreamReader(new FileInputStream("/Users/ethan/Documents/demo/fos.txt"));
			osw = new OutputStreamWriter(new FileOutputStream("/Users/ethan/Documents/demo2/fileCopy.txt"));
			
			char[] chs = new char[1024];
			int ch = 0;
			while((ch = isr.read(chs)) != -1) {
				osw.write(chs, 0, ch);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(osw != null) osw.close();
				if(isr != null) isr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
