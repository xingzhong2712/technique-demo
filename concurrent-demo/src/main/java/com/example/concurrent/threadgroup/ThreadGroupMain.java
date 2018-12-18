package com.example.concurrent.threadgroup;

/**
 * 类职责：<br/>
 *
 * <p>Title: ThreadGroupMain.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月26日 下午下午 1:52
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class ThreadGroupMain {

    public static void main(String[] args) {
        ThreadGroup curTg = Thread.currentThread().getThreadGroup();
        curTg.list();
        System.out.println(curTg);
        System.out.println(curTg.activeCount());
    }

}
