package com.example.concurrent.api;

import java.util.concurrent.TimeUnit;

/**
 * 类职责：<br/>
 *
 * <p>Title: ThreadIsInterrupt.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月10日 下午下午 5:23
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class ThreadIsInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {

            }
        });

        thread.start();

        TimeUnit.MICROSECONDS.sleep(10);
        System.out.printf("thread is interrupted ? %s\n" , thread.isInterrupted());
        thread.interrupt();
        System.out.printf("thread is interrupted ? %s\n" , thread.isInterrupted());
    }
}
