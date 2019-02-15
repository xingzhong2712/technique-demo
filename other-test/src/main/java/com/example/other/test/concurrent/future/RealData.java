package com.example.other.test.concurrent.future;

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
public class RealData implements Data {
	
	protected final String result;
	
	public RealData(String result) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			sb.append(result);
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		this.result = sb.toString();
	}
	
	@Override
	public String getResult() {
		return result;
	}
	
}
