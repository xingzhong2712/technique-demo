package com.example.concurrent.api;

/**
 * 类职责：<br/>
 *
 * <p>Title: ThreadSleep.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月10日 下午上午 10:56
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class ThreadSleep {

    public static void main(String[] args) {
        new Thread(()->{
            long begin = System.currentTimeMillis();
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long end = System.currentTimeMillis();

            System.out.println(String.format("total spend %d ms", (end - begin)));
        }).start();

        long begin = System.currentTimeMillis();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();

        System.out.println(String.format("main thread total spend %d ms", (end - begin)));
    }

}
