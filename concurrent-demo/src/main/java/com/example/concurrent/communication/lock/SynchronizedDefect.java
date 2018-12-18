package com.example.concurrent.communication.lock;

import java.util.concurrent.TimeUnit;

/**
 * 类职责：<br/>
 *
 * <p>Title: SynchronizedDefect.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月19日 下午下午 2:09
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class SynchronizedDefect {

    public static void main(String[] args) {
        SynchronizedDefect defect = new SynchronizedDefect();
        Thread t1 = new Thread(defect::syncMethod, "T1");
        t1.start();

        try {
            TimeUnit.MICROSECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t2 = new Thread(defect::syncMethod,"T2");
        t2.start();
    }

    public synchronized void syncMethod(){
        try {
            TimeUnit.MINUTES.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
