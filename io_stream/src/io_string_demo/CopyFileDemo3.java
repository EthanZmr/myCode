package io_string_demo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFileDemo3 {
	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		
		try {
			fr = new FileReader("/Users/ethan/Documents/demo/fos.txt");
			fw = new FileWriter("/Users/ethan/Documents/demo2/fos_copy.txt");
			
			int ch = 0;
			while((ch = fr.read()) != -1) {
				fw.write(ch);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fw != null) fw.close();
				if(fr != null) fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
}
