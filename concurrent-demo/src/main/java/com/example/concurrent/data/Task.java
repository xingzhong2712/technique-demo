package com.example.concurrent.data;

/**
 * 类职责：<br/>
 *
 * <p>Title: Task.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月11日 下午下午 5:43
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class Task implements Runnable {

    private final static Object MUTEX = new Object();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(Task::new).start();
        }
    }

    @Override
    public void run() {
        synchronized (MUTEX) {}
    }

}
