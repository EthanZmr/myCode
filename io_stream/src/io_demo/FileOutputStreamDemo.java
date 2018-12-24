package io_demo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * IO流的分类：
 * 			流向：
 * 				输入流	读取数据
 * 				输出流	写出数据
 * 			数据类型：
 * 				字节流
 * 					字节输入流	读取数据		InputStream
 * 					字节输出流	写出数据		OutputStream
 * 				字符流
 * 					字符输入流	读取数据		Reader
 * 					字符输出流	写出数据		Writer
 * 
 * 一般在探讨IO流的时候，如果没有明确说明按照那种分类来说，默认情况下是按照数据类型来分的
 */
public class FileOutputStreamDemo {
	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("/Users/ethan/Documents/demo/file.txt");
			String str = "Hello,IOStream";
			byte[] byteArr = str.getBytes();
			fos.write(byteArr);
			fos.close();
		} catch (FileNotFoundException e) {
			System.out.println("文件未找到");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
