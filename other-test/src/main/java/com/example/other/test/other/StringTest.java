package com.example.other.test.other;

import java.util.Arrays;

/**
 * 类职责：String测试类<br/>
 *
 * <p>Title: StringTest.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2019年02月12日 下午 2:37
 * <p></p>
 * <p> </p>
 */
public class StringTest {
	
	static String s1 = "1d";
	
	static String s2 = "1d2";
	
	static int count = 120000;
	
	static {
		System.out.println("s1 : " + s1);
		stringToInt(s1);
		System.out.println("s2 : " + s2);
		stringToInt(s2);
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
	}
	
	static void stringToInt(String s) {
		char[] chars = s.toCharArray();
		int[] ints = new int[chars.length];
		for (int i = 0; i < ints.length; i++) {
			ints[i] = chars[i];
		}
		System.out.println(Arrays.toString(ints));
	}
	
	public static void main(String[] args) {
		String s = "";
		s=s.concat("-123");
		System.out.println(Integer.valueOf(s));
//		testStringSpeed();
//		testCompareTo();
	}
	
	static void testStringSpeed() {
		long begin = System.currentTimeMillis();
		String s = "";
		for (int i = 0; i < count; i++) {
			s += i;
		}
//		System.out.println(s);
		System.out.println("拼接字符串：" + (System.currentTimeMillis() - begin) + " ms");
		System.out.println("*******************************");
		
		begin = System.currentTimeMillis();
		s = null;
		s = "";
		for (int i = 0; i < count; i++) {
			s.concat(String.valueOf(i));
		}
//		System.out.println(s);
		System.out.println("拼接字符串(concact)：" + (System.currentTimeMillis() - begin) + " ms");
		System.out.println("*******************************");
		
		begin = System.currentTimeMillis();
		s = null;
		StringBuilder content = new StringBuilder();
		for (int i = 0; i < count; i++) {
			content.append(i);
		}
//		System.out.println(content);
		System.out.println("拼接字符串(StringBuilder)：" + (System.currentTimeMillis() - begin) + " ms");
	}
	
	static void testCompareTo() {
		int i = s1.compareTo(s2);
		System.out.println(i);
	}
	
	
}
