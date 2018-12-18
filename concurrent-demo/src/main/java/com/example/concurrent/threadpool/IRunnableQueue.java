package com.example.concurrent.threadpool;

/**
 * 类职责：任务队列<br/>
 *
 * <p>Title: IRunnableQueue.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年08月20日 下午下午 2:26
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */
public interface IRunnableQueue {

    /**
     * 当有新的任务进来时首先会offer到队列中
     *
     * @param runnable
     */
    void offer(Runnable runnable);

    /**
     * 工作线程通过take方法获取Runnable
     *
     * @return
     */
    Runnable take() throws InterruptedException;

    /**
     * 获取任务队列中的任务数量
     *
     * @return
     */
    int size();
}
