package com.example.other.test.concurrent.threads;

import java.util.concurrent.TimeUnit;

/**
 * 类职责：<br/>
 *
 * <p>Title: MyThread.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2019年02月15日 下午 7:01
 * <p></p>
 * <p> </p>
 */
public class MyThread implements Runnable {
	
	protected String name;
	
	public MyThread() {
	}
	
	public MyThread(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		long begin = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			new Thread(new MyThread("testNoThreadPool " + i)).start();
		}
		System.out.println("NoThreadPool 消耗时间为：" + (System.currentTimeMillis() - begin) + " ms");
		
		begin = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			ThreadPool.getInstance().start(new MyThread("testTreadPool " + i));
		}
		System.out.println("testTreadPool 消耗时间为：" + (System.currentTimeMillis() - begin) + " ms");
	}
	
}
