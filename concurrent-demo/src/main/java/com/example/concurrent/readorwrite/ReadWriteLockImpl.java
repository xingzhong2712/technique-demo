package com.example.concurrent.readorwrite;

import com.example.concurrent.readorwrite.service.ILock;
import com.example.concurrent.readorwrite.service.IReadWriteLock;


/**
 * 类职责：<br/>
 *
 * <p>Title: ReadWriteLockImpl.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年12月11日 下午下午 2:58
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class ReadWriteLockImpl implements IReadWriteLock {

    private final Object MUTEX = new Object();

    private int writingWriters = 0;
    private int waitingWriters = 0;
    private int readingReaders = 0;

    private boolean preferWriter;

    public ReadWriteLockImpl() {
        this(true);
    }

    public ReadWriteLockImpl(boolean preferWriter) {
        this.preferWriter = preferWriter;
    }

    @Override
    public ILock readLock() {
        return new ReadLock(this);
    }

    @Override
    public ILock writeLock() {
        return new WriteLock(this);
    }

    @Override
    public int getWritingWriters() {
        return this.writingWriters;
    }

    @Override
    public int getReadingWriters() {
        return this.readingReaders;
    }

    public int getWaitingWriters() {
        return this.waitingWriters;
    }

    void incrementWaitingWriters() {
        this.waitingWriters++;
    }

    void incrementWritingWriters() {
        this.writingWriters++;
    }

    void incrementReadingReaders() {
        this.readingReaders++;
    }

    void decrementWaitingWriters() {
        this.waitingWriters--;
    }

    void decrementWritingWriters() {
        this.writingWriters--;
    }

    void decrementReadingReaders() {
        this.readingReaders--;
    }

    Object getMUTEX() {
        return MUTEX;
    }

    boolean getPreferWriter() {
        return this.preferWriter;
    }

    void changePrefer(boolean preferWriter) {
        this.preferWriter = preferWriter;
    }
}
