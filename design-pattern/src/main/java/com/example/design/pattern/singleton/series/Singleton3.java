package com.example.design.pattern.singleton.series;

/**
 * 类职责：懒汉式，保证唯一 实例,但性能低<br/>
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

public class Singleton3 {
    private byte[] data = new byte[1024];

    private static Singleton3 instance = null;

    private Singleton3() {
    }

    public static synchronized Singleton3 getInstance() {
        if (null == instance) {
            instance = new Singleton3();
        }
        return instance;
    }
}
