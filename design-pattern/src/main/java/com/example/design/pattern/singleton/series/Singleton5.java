package com.example.design.pattern.singleton.series;

import java.net.Socket;
import java.sql.Connection;

/**
 * 类职责：懒汉式，double-check保证唯一 实例,性能高,volatile防止指令重排序<br/>
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

public class Singleton5 {
    private byte[] data = new byte[1024];

    private volatile static Singleton5 instance = null;

    Connection connection;

    Socket socket;

    private Singleton5() {
        //初始化
        //this.connection;
        //this.socket;
    }

    public static Singleton5 getInstance() {
        if (null == instance) {
            synchronized (Singleton5.class) {
                if (null == instance) {
                    instance = new Singleton5();
                }
            }
        }
        return instance;
    }
}
