package com.example.concurrent.sample;

import java.util.concurrent.TimeUnit;

/**
 * 类职责：<br/>
 *
 * <p>Title: TryConcurrency.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月09日 下午下午 5:04
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class TryConcurrency {
    public static void main(String args[]){
        //线程启动必须在其中一个任务之前，否则线程将永远得不到启动，因为前一个任务永远不会结束
//        new Thread(() -> enjoyMusic()).start();
        Thread t = new Thread(TryConcurrency::enjoyMusic);
        t.setName("enjoyMusic");
        System.out.println(t.getState());
        t.start();
        System.out.println(t.getState());
//        new Thread(TryConcurrency::enjoyMusic).start();
//        browseNews();

        System.out.println(t.getState());
        t.start();

    }


    private static void browseNews(){
        for(;;){
            System.out.println("uh-huh, the good news.");
            sleep(1);
        }
    }

    private static void enjoyMusic(){
        for(;;){
            System.out.println("uh-huh, the nice music.");
            sleep(1);
        }
    }

    private static void sleep(int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
