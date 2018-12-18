package com.example.concurrent.readorwrite.test;

import static java.lang.Thread.currentThread;

/**
 * 类职责：<br/>
 *
 * <p>Title: ReadWriteLockTest.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年12月11日 下午下午 4:02
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class ReadWriteLockTest {

    private final static String TEXT = "Thisistheexampleforreadwritelock.";

    public static void main(String[] args) {
        final ShareData shareData = new ShareData(50);
        // 创建2个线程进行数据写操作
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int index = 0; index < TEXT.length(); index++) {
                    try {
                        char c = TEXT.charAt(index);
                        System.out.println(currentThread() + " write start: " + index);
                        shareData.write(c);
                        System.out.println(currentThread() + " write " + c);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        // 创建10个线程进行数据读操作
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    try {
                        System.out.println("write read.. ");
                        System.out.println(currentThread() + " read " + new String(shareData.read()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }).start();
        }
    }
}
