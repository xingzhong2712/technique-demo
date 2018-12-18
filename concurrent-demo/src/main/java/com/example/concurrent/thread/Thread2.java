package com.example.concurrent.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 类职责：<br/>
 *
 * <p>Title: Thread2.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月10日 下午上午 10:27
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class Thread2 extends Thread {

    private final static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String args[]){
        try {

            while (true){
                new Thread2().start();
            }
        }catch (Throwable t){
            System.out.println("failed " + counter.get());
        } finally {
            System.out.println("thread is over .");
        }
    }

    @Override
    public void run() {
        System.out.println("the " + counter.getAndIncrement() + " thread is created.");
        try {
            TimeUnit.MINUTES.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
