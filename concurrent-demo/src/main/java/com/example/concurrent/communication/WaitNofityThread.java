package com.example.concurrent.communication;

/**
 * 类职责：<br/>
 * 1.wait和notify必须在童虎方法获取同步锁的情况下执行
 * 2.调用wait和notify的对象必须和获取同步锁的对象是同一个
 *
 * <p>Title: WaitNofityThread.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月19日 下午上午 10:25
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class WaitNofityThread {

    private void testWait1(){
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void testNofify1(){
        this.notify();
    }


    private final Object MUTEX = new Object();
    private synchronized void testWait2(){
        try {
            MUTEX.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized void testNofify2(){
        MUTEX.notify();
    }
}
