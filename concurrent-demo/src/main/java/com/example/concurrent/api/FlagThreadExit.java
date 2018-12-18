package com.example.concurrent.api;

import java.util.concurrent.TimeUnit;

/**
 * 类职责：<br/>
 *
 * <p>Title: FlagThreadExit.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月11日 下午下午 2:00
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class FlagThreadExit {
    public static void main(String[] args) throws InterruptedException {
        MyTask myTask = new MyTask();
        myTask.start();

        TimeUnit.SECONDS.sleep(10);
        System.out.println("system will be shutdown.");
        myTask.close();
    }
    static class MyTask extends Thread{
        private volatile boolean closed = false;

        @Override
        public void run() {
            System.out.println("i will start a job.");
            while (!closed && isInterrupted()){

            }

            System.out.println("i will be exiting.");
        }

        public void close(){
            this.closed = true;
            this.interrupt();
        }
    }
}
