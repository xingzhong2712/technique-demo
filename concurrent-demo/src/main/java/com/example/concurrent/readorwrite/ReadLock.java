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

class ReadLock implements ILock {

    private final ReadWriteLockImpl readWriteLock;

    ReadLock(ReadWriteLockImpl readWriteLock) {
        this.readWriteLock = readWriteLock;
    }

    @Override
    public void lock() throws InterruptedException {
        synchronized (readWriteLock.getMUTEX()) {
            //若此时有线程在进行写操作，或者有写线程在等待并且偏向写锁的标识为true时，就会无法获得读锁，只能被挂起
            while (readWriteLock.getWritingWriters() > 0
                    || (readWriteLock.getPreferWriter()
                    && readWriteLock.getWaitingWriters() > 0)) {
                readWriteLock.getMUTEX().wait();
            }

            //成功获取的读锁，并且使readingReaders的数量增加
            readWriteLock.incrementReadingReaders();
        }
    }

    @Override
    public void unlock() {
        synchronized (readWriteLock.getMUTEX()) {
            //释放锁的过程就是使得当前reading的数量减一
            readWriteLock.decrementReadingReaders();
            //将preferWriter设置为true，可以使得writer线程获得更多的机会
            readWriteLock.changePrefer(true);
            //通知唤醒与MUTEX关联的monitor，wait set中的线程
            readWriteLock.getMUTEX().notifyAll();
        }
    }

}
