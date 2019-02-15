package com.example.other.test.concurrent.masterworker;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * 类职责：<br/>
 *
 * <p>Title: Master.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2019年02月15日 下午 3:45
 * <p></p>
 * <p> </p>
 */
public class Master {
	
	/**
	 * 任务队列
	 */
	protected Queue<Object> workQueue = new ConcurrentLinkedDeque<>();
	
	/**
	 * Worker进程队列
	 */
	protected Map<String, Thread> threadMap = new HashMap<>();
	
	/**
	 * 子任务处理结果集
	 */
	protected Map<String, Object> resultMap = new ConcurrentHashMap<>();
	
	
	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}
	
	public boolean isComplete() {
		for (Map.Entry<String, Thread> entry : threadMap.entrySet()) {
			if (entry.getValue().getState() != Thread.State.TERMINATED) {
				return false;
			}
		}
		
		return true;
	}
	
	public Master(Worker worker, int countWorker) {
		worker.setWorkQueue(workQueue);
		worker.setResultMap(resultMap);
		for (int i = 0; i < countWorker; i++) {
			threadMap.put(Integer.toString(i), new Thread(worker, Integer.toString(i)));
		}
	}
	
	public void submit(Object object) {
		workQueue.add(object);
	}
	
	public void execute() {
		for (Map.Entry<String,Thread> entry : threadMap.entrySet()){
			entry.getValue().start();
		}
	}
}
