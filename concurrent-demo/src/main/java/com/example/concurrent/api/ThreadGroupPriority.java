package com.example.concurrent.api;

/**
 * 类职责：<br/>
 *
 * <p>Title: ThreadGroupPriority.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月10日 下午下午 5:10
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class ThreadGroupPriority {

    public static void main(String[] args) {
        ThreadGroup group = new ThreadGroup("test1");
        group.setMaxPriority(9);
        Thread thread = new Thread(group, "test_thread");
        thread.setPriority(10);

        System.out.println("group priority is " + thread.getPriority());
        System.out.println("thread is is " + thread.getId());
    }

}
