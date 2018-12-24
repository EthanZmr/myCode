package io_string_demo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyDemo2 {
	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		
		try {
			fr = new FileReader("/Users/ethan/Documents/demo/fos.txt");
			fw = new FileWriter("/Users/ethan/Documents/demo2/filecopy2.txt");
			
			char[] chs = new char[1024];
			int ch = 0;
			while((ch = fr.read(chs)) != -1) {
				fw.write(chs, 0, ch);
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
