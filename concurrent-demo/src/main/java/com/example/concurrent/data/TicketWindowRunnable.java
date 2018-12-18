package com.example.concurrent.data;

import java.util.Objects;

/**
 * 类职责：<br/>
 *
 * <p>Title: TicketWindowRunnable.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月11日 下午下午 4:47
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class TicketWindowRunnable implements Runnable {

    private int index = 1;

    private final static int MAX = 100;

    private final static Object MUTEX = new Object();

    public static void main(String[] args) {
        final TicketWindowRunnable task = new TicketWindowRunnable();
        Thread t1 = new Thread(task, "一号窗口");
        Thread t2 = new Thread(task, "二号窗口");
        Thread t3 = new Thread(task, "三号窗口");
        Thread t4 = new Thread(task, "四号窗口");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }

    @Override
    public void run() {
        synchronized (MUTEX) {
            while (index <= MAX) {
                System.out.println(Thread.currentThread() + " 的号码是：" + (index++));
            }
        }
    }

}
