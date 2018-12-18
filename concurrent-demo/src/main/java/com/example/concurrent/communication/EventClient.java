package com.example.concurrent.communication;

import java.util.concurrent.TimeUnit;

/**
 * 类职责：<br/>
 *
 * <p>Title: EventClient.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月18日 下午下午 6:06
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class EventClient {

    public static void main(String[] args) {
        final EventQueue eventQueue = new EventQueue();

        new Thread(()->{
            for (;;){
                eventQueue.offer(new EventQueue.Event());
            }
        }, "Producer").start();

        new Thread(()->{
            for (;;){
                eventQueue.take();
                try {
                    TimeUnit.MICROSECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Consumer").start();
    }
}
