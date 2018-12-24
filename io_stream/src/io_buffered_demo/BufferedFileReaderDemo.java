package io_buffered_demo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedFileReaderDemo {
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("/Users/ethan/Documents/demo/file.txt"));
			
			int ch = 0;
			while((ch = br.read()) != -1) {
				System.out.println((char)ch);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(br != null) {br.close();}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
