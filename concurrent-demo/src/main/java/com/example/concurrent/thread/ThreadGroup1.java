package com.example.concurrent.thread;

/**
 * 类职责：<br/>
 *
 * <p>Title: ThreadGroup1.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月10日 下午上午 9:32
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class ThreadGroup1 {

    public static void main(String args[]){
        Thread t1 = new Thread("test-thread1");

        ThreadGroup tg1 = new ThreadGroup("test-thread-group1");

        Thread t2 = new Thread(tg1, "test-thread2");

        ThreadGroup tg2 = Thread.currentThread().getThreadGroup();
        System.out.println("main thread belong group " + tg2.getName());

        System.out.println("t1 == t2 ? " + (t1 == t2));

        System.out.println("main thread ==  t1 ? " + (tg2 == t1.getThreadGroup()));
        System.out.println("main thread ==  t2 ? " + (tg2 == t2.getThreadGroup()));



    }

}
