package com.example.other.test.concurrent.future;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * 类职责：<br/>
 *
 * <p>Title: RealData.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2019年02月15日 下午 1:27
 * <p></p>
 * <p> </p>
 */
public class RealDataV2 implements Callable<String> {
	
	protected String result;
	
	public RealDataV2(String result) {
		this.result = result;
	}
	
	@Override
	public String call() throws Exception {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			sb.append(result);
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		return sb.toString();
	}
}
