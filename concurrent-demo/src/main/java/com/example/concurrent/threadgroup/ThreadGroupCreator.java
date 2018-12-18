package com.example.concurrent.threadgroup;

/**
 * 类职责：<br/>
 *
 * <p>Title: ThreadGroupCreator.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月25日 下午下午 6:18
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class ThreadGroupCreator {

    public static void main(String[] args) {
        ThreadGroup curTg = Thread.currentThread().getThreadGroup();
        ThreadGroup tg1 = new ThreadGroup("Group1");

        System.out.println(tg1.getParent() == curTg);
        ThreadGroup tg2 = new ThreadGroup(tg1,"Group2");
        System.out.println(tg2.getParent() == tg1);
    }

}
