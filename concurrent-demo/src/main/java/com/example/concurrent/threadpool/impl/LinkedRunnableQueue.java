package com.example.concurrent.threadpool.impl;

import com.example.concurrent.threadpool.IDenyPolicy;
import com.example.concurrent.threadpool.IRunnableQueue;
import com.example.concurrent.threadpool.IThreadPool;

import java.util.LinkedList;

/**
 * 类职责：<br/>
 *
 * <p>Title: LinkedRunnableQueue.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年08月20日 下午下午 2:45
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class LinkedRunnableQueue implements IRunnableQueue {

    /**
     * 任务队列最大容量
     */
    private final int limit;

    /**
     * 任务队列中的任务已满，则需要执行的拒绝策略
     */
    private final IDenyPolicy denyPolicy;

    /**
     * 任务队列
     */
    private final LinkedList<Runnable> runnableList = new LinkedList<>();

    private final IThreadPool threadPool;

    public LinkedRunnableQueue(int limit, IDenyPolicy denyPolicy, IThreadPool threadPool) {
        this.limit = limit;
        this.denyPolicy = denyPolicy;
        this.threadPool = threadPool;
    }

    @Override
    public void offer(Runnable runnable) {
        synchronized (runnableList) {
            if (runnableList.size() >= limit) {
                //无法容纳新的任务时执行拒绝策略
                denyPolicy.reject(runnable, threadPool);
            } else {
                //将任务加入队尾，并且唤醒阻塞中的线程
                runnableList.addLast(runnable);
                runnableList.notifyAll();
            }
        }
    }

    @Override
    public Runnable take() throws InterruptedException {
        synchronized (runnableList) {
            while (runnableList.isEmpty()) {
                try {
                    //如果任务队列中没有可执行任务，则当前线程将会挂起，进入runnable关联的monitor waitset中等待唤醒
                    runnableList.wait();
                } catch (InterruptedException e) {
                    throw e;
                }
            }
            //从任务队列头移除一个任务
            return runnableList.removeFirst();
        }
    }

    @Override
    public int size() {
        synchronized (runnableList) {
            return runnableList.size();
        }
    }

}
