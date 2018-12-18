package com.example.concurrent.communication.lock.service.impl;

import com.example.concurrent.communication.lock.service.ILock;

import java.time.Clock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeoutException;

/**
 * 类职责：<br/>
 *
 * <p>Title: BooleanLockImpl.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月19日 下午下午 2:26
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class BooleanLockImpl implements ILock {

    private Thread currentThread;

    private boolean locked = false;

    private final List<Thread> blockedList = new ArrayList<>();

    private static Thread getCurrentThread() {
        return Thread.currentThread();
    }

    @Override
    public void lock() throws InterruptedException {
        synchronized (this) {
            while (locked) {
                final Thread tmpThread = getCurrentThread();
                try {
                    if (!blockedList.contains(getCurrentThread())) {
                        blockedList.add(getCurrentThread());
                    }
                    this.wait();
                } catch (InterruptedException e) {
                    blockedList.remove(tmpThread);
                    throw e;
                }
            }

            blockedList.remove(currentThread);
            this.locked = true;
            this.currentThread = getCurrentThread();
        }
    }

    @Override
    public void lock(long mills) throws InterruptedException, TimeoutException {
        synchronized (this) {
            if (mills <= 0) {
                this.lock();
            } else {
                long remainingMills = mills;
                long endMills = currentTimeMills() + remainingMills;

                while (locked) {
                    if (remainingMills <= 0) {
                        throw new TimeoutException("can not get the lock during " + mills + " ms.");
                    }

                    final Thread tmpThread = getCurrentThread();
                    try {
                        if (!blockedList.contains(getCurrentThread())) {
                            blockedList.add(getCurrentThread());
                        }
                        this.wait(remainingMills);
                    } catch (InterruptedException e) {
                        blockedList.remove(tmpThread);
                        throw e;
                    }
                    remainingMills = endMills - currentTimeMills();
                }

                blockedList.remove(getCurrentThread());
                this.locked = true;
                this.currentThread = getCurrentThread();
            }
        }
    }

    private long currentTimeMills() {
        return Clock.systemDefaultZone().millis();
    }

    @Override
    public void unLock() {
        synchronized (this) {
            if (currentThread == getCurrentThread()) {
                this.locked = false;
                Optional.of(getCurrentThread().getName() + " release the lock.").ifPresent(System.out::println);
                this.notify();
            }
        }
    }

    @Override
    public List<Thread> getBlockedThreads() {
        return Collections.unmodifiableList(blockedList);
    }
}
