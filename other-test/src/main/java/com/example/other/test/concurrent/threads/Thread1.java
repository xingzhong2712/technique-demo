package com.example.other.test.concurrent.threads;

/**
 * 类职责：<br/>
 *
 * <p>Title: Thread1.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2019年02月15日 下午 5:38
 * <p></p>
 * <p> </p>
 */
public class Thread1 {
	
	public static void main(String[] args) {
		new Thread(() -> System.out.println("do sth.")).start();
	}
	
}
