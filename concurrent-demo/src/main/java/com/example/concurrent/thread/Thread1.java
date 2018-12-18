package com.example.concurrent.thread;

import java.util.stream.IntStream;

/**
 * 类职责：<br/>
 *
 * <p>Title: Thread1.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月10日 下午上午 9:19
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class Thread1 extends Thread {

    private final static String PREFIX = "SEEN-TEST-";

    public static void main(String args[]) {
        IntStream.range(0, 5).mapToObj(Thread1::createThread).forEach(Thread::start);


        System.out.println(Thread.currentThread());
        System.out.println(Thread.currentThread().getThreadGroup().getName());
        Thread thread = new Thread("test-thread");
        thread.start();
        System.out.println(thread.getThreadGroup().getParent());
    }

    private static Thread createThread(final int intName) {
        return new Thread(() -> System.out.println(Thread.currentThread().getName()), PREFIX + intName);
    }
}
