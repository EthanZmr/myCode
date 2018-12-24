package com.ethan.base64;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.Test;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Demo {
	@Test
	public void fun1() throws IOException {
		String s = "username";
		BASE64Encoder encoder = new BASE64Encoder();
		String s1 = encoder.encode(s.getBytes("utf-8"));
		System.out.println(s1);
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] s2 = decoder.decodeBuffer(s1);
		String s3 = new String(s2, "utf-8");
		System.out.println(s3);
	}
}
