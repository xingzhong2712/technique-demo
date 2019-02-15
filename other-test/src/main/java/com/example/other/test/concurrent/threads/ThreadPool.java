package com.example.other.test.concurrent.threads;

import lombok.Getter;

import java.util.List;
import java.util.Vector;

/**
 * 类职责：<br/>
 *
 * <p>Title: ThreadPool.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2019年02月15日 下午 6:13
 * <p></p>
 * <p> </p>
 */
@Getter
public class ThreadPool {
	
	private static ThreadPool instance = null;
	
	private List<PThread> idleThreads;
	
	private int threadCounter;
	
	private boolean isShutdown = false;
	
	public ThreadPool() {
		this.idleThreads = new Vector<>(5);
		threadCounter = 0;
	}
	
	public synchronized static ThreadPool getInstance() {
		if (instance == null) {
			instance = new ThreadPool();
		}
		
		return instance;
	}
	
	protected synchronized void repool(PThread repoolingThread) {
		if (!isShutdown) {
			idleThreads.add(repoolingThread);
		} else {
			repoolingThread.shutdown();
		}
	}
	
	public synchronized void shutdown() {
		isShutdown = true;
		for (int threadIndex = 0; threadIndex < idleThreads.size(); threadIndex++) {
			PThread idleThread = idleThreads.get(threadIndex);
			idleThread.shutdown();
		}
	}
	
	public synchronized void start(Runnable target) {
		PThread thread = null;
		
		//如果有空闲线程，则直接使用
		if (idleThreads.size() > 0) {
			int lastIndex = idleThreads.size() - 1;
			thread = idleThreads.get(lastIndex);
			idleThreads.remove(lastIndex);
			// 立即执行这个任务
			thread.setTarget(target);
		} else {    //没有空闲线程，创建新的线程
			threadCounter++;
			thread = new PThread(this, target, "PThread #" + threadCounter);
			thread.start();
		}
	}
}
