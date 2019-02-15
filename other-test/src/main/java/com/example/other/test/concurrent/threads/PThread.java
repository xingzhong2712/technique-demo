package com.example.other.test.concurrent.threads;

import lombok.Getter;

/**
 * 类职责：<br/>
 *
 * <p>Title: PThread.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2019年02月15日 下午 6:15
 * <p></p>
 * <p> </p>
 */
@Getter
public class PThread extends Thread {
	
	private ThreadPool pool;
	
	private Runnable target;
	
	private boolean isShutdown = false;
	
	private boolean isIdle = false;
	
	public PThread(ThreadPool pool, Runnable target, String name) {
		super(name);
		this.pool = pool;
		this.target = target;
	}
	
	@Override
	public void run() {
		while (!isShutdown) {
			isIdle = false;
			if (target != null) {
				target.run();
			}
			// 任务结束，到闲置状态
			isIdle = true;
			
			try {
				// 该任务结束后，不关闭线程，而是放入线程池空闲队列
				pool.repool(this);
				synchronized (this) {
					// 线程空闲，等待新的任务到来
					wait();
				}
			} catch (InterruptedException e) {}
			isIdle = false;
		}
	}
	
	public synchronized void setTarget(Runnable newTarget) {
		target = newTarget;
		// 设置任务之后，通知run()，开始执行这个任务
		notifyAll();
	}
	
	public synchronized void shutdown() {
		isShutdown = true;
		notifyAll();
	}
	
}
