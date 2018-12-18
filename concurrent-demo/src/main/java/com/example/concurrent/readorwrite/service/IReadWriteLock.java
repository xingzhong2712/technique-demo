package com.example.concurrent.readorwrite.service;

import com.example.concurrent.readorwrite.ReadWriteLockImpl;

/**
 * 类职责：<br/>
 *
 * <p>Title: IReadWriteLock.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年12月11日 下午下午 2:53
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public interface IReadWriteLock {

    ILock readLock();

    ILock writeLock();

    int getWritingWriters();

    int getReadingWriters();

    static IReadWriteLock readWriteLock() {
        return new ReadWriteLockImpl();
    }

    static IReadWriteLock readWriteLock(boolean preferWriter) {
        return new ReadWriteLockImpl(preferWriter);
    }
}
