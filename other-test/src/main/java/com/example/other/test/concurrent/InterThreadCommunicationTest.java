package com.example.other.test.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * 类职责：线程通信<br/>
 *
 * <p>Title: InterThreadCommunicationTest.java</p>
 * <p>Description: 线程通信</p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2019年02月15日 下午 2:34
 * <p></p>
 * <p> </p>
 */
public class InterThreadCommunicationTest {
	
	public static void main(String[] args) {
		demo3();
//		demo2();
//		demo1();
	}
	
	/**
	 * 两条线程，无序执行
	 */
	private static void demo1() {
		Thread a = new Thread(() -> printNum("A"));
		
		Thread b = new Thread(() -> printNum("B"));
		
		a.start();
		b.start();
	}
	
	private static void printNum(String threadName) {
		int i = 0;
		while (i++ < 3) {
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(threadName + " print: " + i);
		}
	}
	
	
	/**
	 * 两条线程，B等待A执行完再执行
	 */
	private static void demo2() {
		Thread a = new Thread(() -> printNum("A"));
		
		Thread b = new Thread(() -> {
			System.out.println("B 等待 A ！");
			try {
				a.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			printNum("B");
		});
		
		a.start();
		b.start();
	}
	
	/**
	 * 两条线程，交替有序执行
	 */
	private static void demo3() {
		Thread a = new Thread(() -> {
			System.out.println("A 等待锁！");
			synchronized (LOCK) {
				System.out.println("A 1");
				try {
					System.out.println("A 准备进入等待状态，放弃锁LOCK的控制权！");
					LOCK.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println("有人唤醒了 A,A重新获得所LOCK！");
				System.out.println("A 2");
				System.out.println("A 3");
			}
		}, "A");
		
		Thread b = new Thread(() -> {
			System.out.println("B 等待锁！");
			synchronized (LOCK) {
				System.out.println("B 获得锁LOCK的控制权！");
				System.out.println("B 1");
				System.out.println("B 2");
				System.out.println("B 3");
				System.out.println("B打印完毕，调用notify方法！");
				LOCK.notify();
			}
		}, "B");
		
		a.start();
		b.start();
	}
	
	private final static Object LOCK = new Object();
	
}
