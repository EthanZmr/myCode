package io_buffered_demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * 字符缓冲流的特殊方法
 * 		BufferedWriter:public void newLine();根据系统来决定换行符
 * 		BufferedReader:public String readLine();一次读取一行
 */
public class BufferedStreamDemo {
	public static void main(String[] args) {
		BufferedWriter bw = null;
		BufferedReader br = null;
		
		try {
			bw = new BufferedWriter(new FileWriter("/Users/ethan/Documents/demo/hello.txt"));
			br = new BufferedReader(new FileReader("/Users/ethan/Documents/demo/fos.txt"));
			
			String line = null;
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
			
			System.out.println("================================================");
			
			for (int i = 0; i < 10; i++) {
				bw.write("hello" + i);
				bw.newLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(br != null) br.close();
				if(bw != null) bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
