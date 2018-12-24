package io_buffered_demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFileDemo {
	public static void main(String[] args) {
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			br = new BufferedReader(new FileReader("/Users/ethan/Documents/demo/fos.txt"));
			bw = new BufferedWriter(new FileWriter("/Users/ethan/Documents/demo2/copyfos2.txt"));
			
			String line = null;
			while((line = br.readLine()) != null) {
				bw.write(line);
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bw != null) bw.close();
				if(br != null) br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
