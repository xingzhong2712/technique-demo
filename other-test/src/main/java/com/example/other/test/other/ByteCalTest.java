package com.example.other.test.other;

/**
 * 类职责：<br/>
 *
 * <p>Title: ByteCalTest.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2019年02月12日 下午 2:02
 * <p></p>
 * <p> </p>
 */
public class ByteCalTest {
	
	public static void main(String[] args) {
		int n = 16;
		n |= n >>> 1;
		System.out.println(n);
		n |= n >>> 2;
		System.out.println(n);
		n |= n >>> 4;
		System.out.println(n);
		n |= n >>> 8;
		System.out.println(n);
		n |= n >>> 16;
		System.out.println(n);
	}
	
}
