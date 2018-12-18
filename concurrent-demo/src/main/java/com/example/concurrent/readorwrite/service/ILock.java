package com.example.concurrent.readorwrite.service;

/**
 * 类职责：<br/>
 *
 * <p>Title: ILock.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年12月11日 下午下午 2:32
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */
public interface ILock {

    void lock() throws InterruptedException;

    void unlock();
}
