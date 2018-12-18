package com.example.concurrent.communication.lock;

import com.example.concurrent.communication.lock.service.ILock;
import com.example.concurrent.communication.lock.service.impl.BooleanLockImpl;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.IntStream;

import static java.lang.Thread.currentThread;
import static java.util.concurrent.ThreadLocalRandom.current;

/**
 * 类职责：<br/>
 *
 * <p>Title: BooleanLockTest.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月25日 下午下午 5:53
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class BooleanLockTest {

    private final ILock lock = new BooleanLockImpl();

    public static void main(String[] args) {
        BooleanLockTest booleanLockTest = new BooleanLockTest();
        IntStream.range(0, 10).mapToObj(i -> new Thread(booleanLockTest::syncMethod)).forEach(Thread::start);
    }

    public void syncMethod() {
        try {
            lock.lock();
            int randomInt = current().nextInt(10);
            System.out.println(currentThread() + " get the lock.");
            TimeUnit.SECONDS.sleep(randomInt);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unLock();
        }
    }


    public void syncMethodTimeout() {
        try {
            lock.lock(1000);
            int randomInt = current().nextInt(10);
            System.out.println(currentThread() + " get the lock.");
            TimeUnit.SECONDS.sleep(randomInt);
        } catch (InterruptedException | TimeoutException e) {
            e.printStackTrace();
        } finally {
            lock.unLock();
        }
    }

}
