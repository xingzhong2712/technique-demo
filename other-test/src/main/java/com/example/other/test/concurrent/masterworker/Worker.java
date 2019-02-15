package com.example.other.test.concurrent.masterworker;

import java.util.Map;
import java.util.Queue;

/**
 * 类职责：<br/>
 *
 * <p>Title: Worker.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2019年02月15日 下午 3:41
 * <p></p>
 * <p> </p>
 */
public class Worker implements Runnable {
	
	protected Queue<Object> workQueue;
	
	protected Map<String, Object> resultMap;
	
	public void setWorkQueue(Queue<Object> workQueue) {
		this.workQueue = workQueue;
	}
	
	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}
	
	public Object handle(Object input) {
		return input;
	}
	
	@Override
	public void run() {
		while (true) {
			Object input = workQueue.poll();
			if (input == null) {
				break;
			}
			
			Object re = handle(input);
			resultMap.put(Integer.toString(input.hashCode()), re);
		}
	}
	
}
