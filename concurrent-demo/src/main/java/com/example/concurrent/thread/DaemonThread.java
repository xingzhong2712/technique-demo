package com.example.concurrent.thread;

/**
 * 类职责：<br/>
 *
 * <p>Title: DaemonThread.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月10日 下午上午 10:45
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class DaemonThread {

    public static void main(String args[]) throws InterruptedException {

        Thread thread = new Thread(()->{
            while (true){
                try {
                    System.out.println("this is my created thread.");
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);

        thread.start();
        Thread.sleep(100);
        System.out.println("main thread finished lifecycle.");
    }
}
