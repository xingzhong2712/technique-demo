package com.example.concurrent.api;

import java.util.concurrent.TimeUnit;

/**
 * 类职责：<br/>
 *
 * <p>Title: ThreadInterrupted.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月10日 下午下午 5:30
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class ThreadInterrupted {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            while (true){
                System.out.println(Thread.interrupted());
            }
        });

        thread.setDaemon(true);
        thread.start();

        TimeUnit.MICROSECONDS.sleep(10);
        thread.interrupt();
    }

}
