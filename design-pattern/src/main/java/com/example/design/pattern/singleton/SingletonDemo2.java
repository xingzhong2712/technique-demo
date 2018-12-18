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

public class SingletonDemo2 {

    private static SingletonDemo2 instance = null ;

    private SingletonDemo2(){
        System.out.println("create a singleton object");
    }

    public static synchronized SingletonDemo2 getInstance(){
        if (instance == null){
            instance = new SingletonDemo2();
        }
        return instance;
    }

    public static void createAString(){
        System.out.println("create a string ");
    }

}
