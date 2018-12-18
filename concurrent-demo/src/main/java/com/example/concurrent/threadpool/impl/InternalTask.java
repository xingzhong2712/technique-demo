package com.example.concurrent.threadpool.impl;

import com.example.concurrent.threadpool.IRunnableQueue;

/**
 * 类职责：<br/>
 *
 * <p>Title: InternalTask.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年08月20日 下午下午 2:39
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class InternalTask implements Runnable {

    private final IRunnableQueue runnableQueue;

    private volatile boolean running = true;

    public InternalTask(IRunnableQueue runnableQueue) {
        this.runnableQueue = runnableQueue;
    }


    @Override
    public void run() {
        //如果当前任务为running且没有被中断，则其将不断地从queue中获取runnable，然后执行run方法
        while (running && !Thread.currentThread().isInterrupted()) {
            try {
                Runnable task = runnableQueue.take();
                task.run();
            } catch (InterruptedException e) {
                running = false;
                break;
            }
        }
    }

    public void stop() {
        this.running = false;
    }
}
