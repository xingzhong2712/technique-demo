package com.example.concurrent.api;

import java.util.concurrent.TimeUnit;

/**
 * 类职责：<br/>
 *
 * <p>Title: InterruptThreadExit.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月11日 下午下午 1:55
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class InterruptThreadExit {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println("i will start a job.");
                while (!isInterrupted()) {

                }

                System.out.println("i will be exiting.");
            }
        };

        t.start();
        TimeUnit.SECONDS.sleep(6);
        System.out.println("system will be shutdown.");
        t.interrupt();
    }
}
