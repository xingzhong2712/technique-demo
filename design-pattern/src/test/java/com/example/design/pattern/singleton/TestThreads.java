package com.example.design.pattern.singleton;

/**
 * 类职责：<br/>
 *
 * <p>Title: TestThreads.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月06日 下午下午 5:38
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class TestThreads extends Thread {

    public static void main(String args[]) {
        new Thread().start();
    }

    @Override
    public void run() {
        System.out.println("start a new thread .");
        /*long beginTime = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            SingletonDemo.getInstance();
        }
        long endTime = System.currentTimeMillis();

        System.out.println("spend time is " + (endTime - beginTime));*/
    }

}
