package com.example.concurrent.api;

/**
 * 类职责：<br/>
 *
 * <p>Title: ThreadPriority.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月10日 下午下午 5:01
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class ThreadPriority {

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            while (true){
                System.out.println("t1");
            }
        });

        t1.setPriority(3);


        Thread t2 = new Thread(()->{
            while (true){
                System.out.println("t2");
            }
        });

        t2.setPriority(10);

        t1.start();
        t2.start();
    }

}
