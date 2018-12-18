package com.example.concurrent.classloader.litedemo;

/**
 * 类职责：<br/>
 *
 * <p>Title: Simple.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年09月21日 下午上午 11:34
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class Simple {

    static {
        System.out.println("I will be init..");
    }

    public static int x = 10;


    public static void test() {}

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.example.concurrent.classloader.litedemo.Simple");
    }

}
