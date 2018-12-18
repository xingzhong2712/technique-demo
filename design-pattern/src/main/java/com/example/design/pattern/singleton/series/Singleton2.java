package com.example.design.pattern.singleton.series;

/**
 * 类职责：懒汉式，无法保证唯一 实例<br/>
 *
 * <p>Title: Singleton2.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年12月05日 下午下午 4:53
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class Singleton2 {
    private byte[] data = new byte[1024];

    private static Singleton2 instance = null;

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        if (null == instance) {
            instance = new Singleton2();
        }
        return instance;
    }
}
