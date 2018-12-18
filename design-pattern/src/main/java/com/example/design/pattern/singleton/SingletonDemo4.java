package com.example.design.pattern.singleton;

/**
 * 类职责：<br/>
 *
 * <p>Title: SingletonDemo.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月06日 下午下午 5:23
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class SingletonDemo4 {

    private static class SingletonInner {
        private static SingletonDemo4 instance = new SingletonDemo4();
    }

    private SingletonDemo4() {
        System.out.println("create a singleton object");
    }

    public static SingletonDemo4 getInstance() {
        return SingletonInner.instance;
    }
}
