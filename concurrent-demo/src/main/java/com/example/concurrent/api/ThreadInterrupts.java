package com.example.concurrent.api;

import java.util.concurrent.TimeUnit;

/**
 * 类职责：<br/>
 *
 * <p>Title: ThreadInterrupts.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月10日 下午下午 5:54
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class ThreadInterrupts {

    public static void main(String[] args) {
        System.out.println("main thread is interrupted ? " + Thread.interrupted());

        Thread.currentThread().interrupt();

        System.out.println("main thread is interrupted ? " + Thread.currentThread().isInterrupted());

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            System.out.println("i will be interrupted still.");
        }
    }

}
