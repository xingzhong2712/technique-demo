package com.example.concurrent.readorwrite;

import com.example.concurrent.readorwrite.service.ILock;

/**
 * 类职责：<br/>
 *
 * <p>Title: ReadLock.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年12月11日 下午下午 3:06
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

class WriteLock implements ILock {

    private final ReadWriteLockImpl readWriteLock;

    WriteLock(ReadWriteLockImpl readWriteLock) {
        this.readWriteLock = readWriteLock;
    }

    @Override
    public void lock() throws InterruptedException {
        synchronized (readWriteLock.getMUTEX()) {
            try {
                //首先使等待获取写入锁的数字加1
                readWriteLock.incrementWaitingWriters();
                //若此时有线程在进行读操作，或写操作，那么当前相册只能被挂起
                while (readWriteLock.getReadingWriters() > 0
                        || readWriteLock.getWritingWriters() > 0) {
                    readWriteLock.getMUTEX().wait();
                }
            } finally {
                //成功获取写入锁，是的等待获取写入锁计数器减一
                this.readWriteLock.decrementWaitingWriters();
            }

            readWriteLock.incrementWritingWriters();
        }
    }

    @Override
    public void unlock() {
        synchronized (readWriteLock.getMUTEX()) {
            //减少正在写入锁的线程计数器
            readWriteLock.decrementWritingWriters();
            //将偏好状态设置为false，可以使得读锁获得更多的机会
            readWriteLock.changePrefer(false);
            //通知唤醒与MUTEX关联的monitor，wait set中的线程
            readWriteLock.getMUTEX().notifyAll();
        }
    }

}
