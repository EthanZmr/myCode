package io_string_demo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/*
 * OutputStreamWriter(OutputStream out);字符流
 * OutputStreamWriter(OutputStream out,String charsetName);
 * 		把字节流转换位字符流
 * 		字符流 = 字节流 + 编码表；
 */
public class OutputStreamWriterDemo {
	public static void main(String[] args) {
		OutputStreamWriter osw = null;
		
		try {
			osw = new OutputStreamWriter(new FileOutputStream("/Users/ethan/Documents/demo/osw.txt"));
			
			osw.write("我爱你中国，亲爱的母亲");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(osw != null) osw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
