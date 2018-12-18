package com.example.concurrent.communication.lock.service;

import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * 类职责：<br/>
 *
 * <p>Title: ILock.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月19日 下午下午 2:22
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public interface ILock {

    /**
     * 可中断
     */
    void lock() throws InterruptedException;

    /**
     * 可终端，可超时
     *
     * @param mills
     */
    void lock(long mills) throws InterruptedException, TimeoutException;

    /**
     * 释放锁
     */
    void unLock();

    /**
     * 获取被阻塞的线程
     *
     * @return
     */
    List<Thread> getBlockedThreads();
}
