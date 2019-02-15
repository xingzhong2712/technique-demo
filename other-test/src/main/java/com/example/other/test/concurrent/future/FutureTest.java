package com.example.other.test.concurrent.future;

import java.util.concurrent.*;

/**
 * 类职责：future模式调试<br/>
 *
 * <p>Title: FutureTest.java</p>
 * <p>Description: future模式调试</p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2019年02月15日 下午 1:22
 * <p></p>
 * <p> </p>
 *
 * @author Administrator
 */
public class FutureTest {
	
	public static void main(String[] args) throws Exception {
		test2();
//		test1();
	}
	
	private static void test1() {
		Client client = new Client();
		
		Data data = client.request("name");
		System.out.println("请求结束。。");
		
		try {
			TimeUnit.MILLISECONDS.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("数据=" + data.getResult());
	}
	
	private static void test2() throws ExecutionException, InterruptedException {
		FutureTask<String> futureTask = new FutureTask<>(new RealDataV2("a"));
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		
		executorService.submit(futureTask);
		System.out.println("请求结束。。");
		try {
			TimeUnit.MILLISECONDS.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("数据=" + futureTask.get());
	}
	
}
