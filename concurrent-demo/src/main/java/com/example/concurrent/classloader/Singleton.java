package com.example.concurrent.classloader;

/**
 * 类职责：<br/>
 *
 * <p>Title: Singleton.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年09月21日 下午上午 11:55
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class Singleton {

    private static Singleton instance = new Singleton();

    private static int x = 0;

    private static int y;

//    private static Singleton instance = new Singleton();

    private Singleton() {
        x++;
        y++;
    }

    public static Singleton getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();

        System.out.println(singleton.x);
        System.out.println(singleton.y);
    }
}
