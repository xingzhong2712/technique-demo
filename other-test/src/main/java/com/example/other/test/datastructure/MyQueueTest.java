package com.example.other.test.datastructure;

/**
 * @Title: MyQueueTest.java
 * @Package com.example.other.test.datastructure
 * @Description:
 * @author: Seen
 * @date: 2019.02.20 上午 10:41
 * @Copyright: Copyright (c) 2019 浙江执御信息技术有限公司
 */

public class MyQueueTest {
	
	public static void main(String[] args) {
		MyQueue myQueue = new MyQueue();
		System.out.println(myQueue + ":"+myQueue.length());
		myQueue.add(1);
		myQueue.add(2);
		myQueue.add(4);
		myQueue.add(8);
		myQueue.add(16);
		myQueue.add(32);
		myQueue.add(64);
		myQueue.add(128);
		
		System.out.println(myQueue + ":"+myQueue.length());
		
		myQueue.remove();
		System.out.println(myQueue + ":"+myQueue.length());
		
		System.out.println(myQueue.remove());
		System.out.println(myQueue + ":"+myQueue.length());
		myQueue.remove();
		myQueue.remove();
		myQueue.remove();
		myQueue.add(1234);
		System.out.println(myQueue + ":"+myQueue.length());
		myQueue.remove();
		myQueue.remove();
		myQueue.remove();
		myQueue.remove();
		System.out.println(myQueue + ":"+myQueue.length());
	}
	
}
