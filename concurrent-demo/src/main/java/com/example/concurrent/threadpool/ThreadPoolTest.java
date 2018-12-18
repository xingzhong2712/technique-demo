package com.example.concurrent.threadpool;

import com.example.concurrent.threadpool.impl.BasicThreadPool;

import java.util.concurrent.TimeUnit;

/**
 * 类职责：<br/>
 *
 * <p>Title: ThreadPoolTest.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年08月20日 下午下午 4:05
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class ThreadPoolTest {

    public static void main(String[] args) throws InterruptedException {
        final IThreadPool threadPool = new BasicThreadPool(2,6,4,1000);

        for (int i = 0;i < 20;i++){
            threadPool.execute(()->{
                try {
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println(Thread.currentThread().getName() + " is running and done .");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        for(;;){
            System.out.println("getActiveCount:" + threadPool.getActiveCount());
            System.out.println("getQueueSize:"   +   threadPool.getQueueSize());
            System.out.println("getCoreSize:"    +    threadPool.getCoreSize());
            System.out.println("getMaxSize:"     +     threadPool.getMaxSize());
            System.out.println("=============================================");
            TimeUnit.SECONDS.sleep(5);
        }
    }

}
