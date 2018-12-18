package com.example.concurrent.threadpool.impl;

import com.example.concurrent.threadpool.IDenyPolicy;
import com.example.concurrent.threadpool.IRunnableQueue;
import com.example.concurrent.threadpool.IThreadFactory;
import com.example.concurrent.threadpool.IThreadPool;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 类职责：自定义线程池<br/>
 *
 * <p>Title: BasicThreadPool.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年08月20日 下午下午 3:01
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class BasicThreadPool extends Thread implements IThreadPool {

    /**
     * 初始化线程数量
     */
    private final int initSize;

    /**
     * 最大线程数量
     */
    private final int maxSize;

    /**
     * 核心线程数量
     */
    private final int coreSize;

    /**
     * 活跃线程数量
     */
    private int activeCount;

    /**
     * 创建线程所需的工厂
     */
    private final IThreadFactory threadFactory;

    /**
     * 任务队列
     */
    private final IRunnableQueue runnableQueue;

    private final long keepAliveTime;

    private final TimeUnit timeUnit;

    private volatile boolean isShutDown = false;

    private final Queue<ThreadTask> threadQueue = new ArrayDeque<>();

    private final static IDenyPolicy DEFAULT_DENY_POLICY = new IDenyPolicy.DiscardDenyPolicy();

    private final static IThreadFactory DEFAULT_THREAD_FACTORY = new DefaultThreadFactory();


    public BasicThreadPool(int initSize, int maxSize, int coreSize, int queueSize) {
        this(initSize, maxSize, coreSize, queueSize, DEFAULT_THREAD_FACTORY, DEFAULT_DENY_POLICY, 10, TimeUnit.SECONDS);
    }

    public BasicThreadPool(int initSize, int maxSize, int coreSize, int queueSize, IThreadFactory threadFactory, IDenyPolicy denyPolicy, long keepAliveTime, TimeUnit timeUnit) {
        this.initSize = initSize;
        this.maxSize = maxSize;
        this.coreSize = coreSize;
        this.threadFactory = threadFactory;
        this.runnableQueue = new LinkedRunnableQueue(queueSize, denyPolicy, this);
        this.keepAliveTime = keepAliveTime;
        this.timeUnit = timeUnit;
        this.init();
    }

    private void init() {
        start();
        for (int i = 0; i < initSize; i++) {
            newThread();
        }
    }

    private void newThread() {
        InternalTask internalTask = new InternalTask(runnableQueue);
        Thread thread = this.threadFactory.createThread(internalTask);
        ThreadTask threadTask = new ThreadTask(thread, internalTask);
        threadQueue.offer(threadTask);
        this.activeCount++;
        thread.start();
    }

    private void removeThread() {
        ThreadTask threadTask = threadQueue.remove();
        threadTask.internalTask.stop();
        this.activeCount--;
    }

    @Override
    public void run() {
        while (!isShutDown && isInterrupted()) {
            try {
                timeUnit.sleep(keepAliveTime);
            } catch (InterruptedException e) {
                isShutDown = true;
                break;
            }

            synchronized (this) {
                if (isShutDown) {
                    break;
                }

                //当前队列中有任务尚未处理，并且activeCount < coreSize，则继续扩容
                if (runnableQueue.size() > 0 && activeCount < coreSize) {
                    for (int i = initSize; i < coreSize; i++) {
                        newThread();
                    }
                    continue;
                }

                //当前队列中有任务尚未处理，并且activeCount < maxSize，则继续扩容
                if (runnableQueue.size() > 0 && activeCount < maxSize) {
                    for (int i = coreSize; i < maxSize; i++) {
                        newThread();
                    }
                }

                //任务队列中没有任务，则需要回收，回收至coreSize即可
                if (runnableQueue.size() == 0 && activeCount > coreSize) {
                    for (int i = coreSize; i < activeCount; i++) {
                        removeThread();
                    }
                }

            }
        }

    }

    @Override
    public void execute(Runnable runnable) {
        if (isShutDown) {
            throw new IllegalStateException("The thread pool is destroy .");
        }
        this.runnableQueue.offer(runnable);
    }

    @Override
    public void shutdown() {
        synchronized (this) {
            if (isShutDown) {
                return;
            }

            isShutDown = true;

            threadQueue.forEach(threadTask -> {
                threadTask.internalTask.stop();
                threadTask.thread.interrupt();
            });

            this.interrupt();
        }
    }

    @Override
    public int getInitSize() {
        if (isShutDown) {
            throw new IllegalStateException("The thread pool is destroy .");
        }
        return this.initSize;
    }

    @Override
    public int getMaxSize() {
        if (isShutDown) {
            throw new IllegalStateException("The thread pool is destroy .");
        }
        return this.maxSize;
    }

    @Override
    public int getCoreSize() {
        if (isShutDown) {
            throw new IllegalStateException("The thread pool is destroy .");
        }
        return this.coreSize;
    }

    @Override
    public int getQueueSize() {
        if (isShutDown) {
            throw new IllegalStateException("The thread pool is destroy .");
        }
        return runnableQueue.size();
    }

    @Override
    public int getActiveCount() {
        synchronized (this) {
            return this.activeCount;
        }
    }

    @Override
    public boolean isShutdown() {
        return this.isShutDown;
    }

    private static class ThreadTask {
        Thread thread;
        InternalTask internalTask;

        public ThreadTask(Thread thread, InternalTask internalTask) {
            this.thread = thread;
            this.internalTask = internalTask;
        }
    }

    private static class DefaultThreadFactory implements IThreadFactory {

        private static final AtomicInteger GROUP_COUNTER = new AtomicInteger();

        private static final ThreadGroup group = new ThreadGroup("MyThreadPool-" + GROUP_COUNTER.getAndDecrement());

        private static final AtomicInteger COUNTER = new AtomicInteger(0);

        @Override
        public Thread createThread(Runnable runnable) {
            return new Thread(group, runnable, "thread-pool-" + COUNTER.getAndDecrement());
        }
    }
}
