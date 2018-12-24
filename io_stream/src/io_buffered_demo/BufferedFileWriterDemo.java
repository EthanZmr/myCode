package io_buffered_demo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedFileWriterDemo {
	public static void main(String[] args) {
		BufferedWriter bw = null;
		
		try {
			bw = new BufferedWriter(new FileWriter("/Users/ethan/Documents/demo/fileWriter.txt"));
			
			bw.write("Hello");
			bw.write("World");
			bw.write("java");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
