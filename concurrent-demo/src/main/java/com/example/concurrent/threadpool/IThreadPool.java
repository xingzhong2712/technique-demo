package com.example.concurrent.threadpool;

/**
 * 类职责：<br/>
 *
 * <p>Title: IThreadPool.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年08月20日 下午下午 2:09
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */
public interface IThreadPool {

    /**
     * 提交任务到线程池
     *
     * @param runnable
     */
    void execute(Runnable runnable);

    /**
     * 关闭线程池
     */
    void shutdown();

    /**
     * 获取初始化大小
     *
     * @return
     */
    int getInitSize();

    /**
     * 获取最大线程数
     *
     * @return
     */
    int getMaxSize();

    /**
     * 获取核心线程数量
     *
     * @return
     */
    int getCoreSize();

    /**
     * 获取缓存任务队列的大小
     *
     * @return
     */
    int getQueueSize();

    /**
     * 获取活跃线程数量
     *
     * @return
     */
    int getActiveCount();

    /**
     * 查看线程是否被关闭
     *
     * @return
     */
    boolean isShutdown();
}
