package com.example.other.test.concurrent.future;

/**
 * 类职责：<br/>
 *
 * <p>Title: Client.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2019年02月15日 下午 1:25
 * <p></p>
 * <p> </p>
 */
public class Client {
	
	public Data request(final String qryStr) {
		final FutureData data = new FutureData();
		
		new Thread(() -> {
			RealData realData = new RealData(qryStr);
			data.setRealData(realData);
		}).start();
		
		return data;
	}
}
