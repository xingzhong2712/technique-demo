package com.example.concurrent.threadpool;

/**
 * 类职责：创建线程的工厂类<br/>
 *
 * <p>Title: IThreadFactory.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年08月20日 下午下午 2:29
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */
@FunctionalInterface
public interface IThreadFactory {

    /**
     * 创建线程
     *
     * @param runnable
     * @return
     */
    Thread createThread(Runnable runnable);
}
