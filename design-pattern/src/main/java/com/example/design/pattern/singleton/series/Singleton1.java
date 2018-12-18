package com.example.design.pattern.singleton.series;

/**
 * 类职责：饿汉式<br/>
 *
 * <p>Title: Singleton1.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年12月05日 下午下午 4:52
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class Singleton1 {

    private byte[] data = new byte[1024];

    private static Singleton1 instance = new Singleton1();

    private Singleton1(){}

    public static Singleton1 getInstance(){return instance;}

}
