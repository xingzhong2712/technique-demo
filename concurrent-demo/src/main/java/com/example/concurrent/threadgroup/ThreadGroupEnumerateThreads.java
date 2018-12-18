package com.example.concurrent.threadgroup;

import java.util.concurrent.TimeUnit;

/**
 * 类职责：<br/>
 *
 * <p>Title: ThreadGroupEnumerateThreads.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月25日 下午下午 6:32
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class ThreadGroupEnumerateThreads {

    public static void main(String[] args) {
        ThreadGroup tg = new ThreadGroup("MyGroup");
        System.out.println("初始线程数量：" + tg.activeCount());
        Thread t = new Thread(tg, () -> {
            int i = 0;
            System.out.println("线程开始。。");
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("线程索引：" + i++);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "MyThread");
        t.start();
        System.out.println(t.getThreadGroup() == tg);
        System.out.println(tg);
        try {
            System.out.println("2ms前线程数量：" + tg.activeCount());
            TimeUnit.MICROSECONDS.sleep(2);
            System.out.println("2ms后线程数量：" + tg.activeCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ThreadGroup mainTg = Thread.currentThread().getThreadGroup();
        System.out.println(mainTg);
        mainTg.list();
        System.out.println(mainTg == tg);

        int activeCount = mainTg.activeCount();
        System.out.println(activeCount);

        Thread[] list = new Thread[activeCount];
        int recurseSize = mainTg.enumerate(list);
        System.out.println(recurseSize);

        recurseSize = mainTg.enumerate(list, false);
        System.out.println(recurseSize);
    }

}
