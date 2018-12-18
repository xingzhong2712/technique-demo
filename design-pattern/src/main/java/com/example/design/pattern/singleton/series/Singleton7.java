package com.example.design.pattern.singleton.series;

/**
 * 类职责：<br/>
 *
 * <p>Title: Singleton7.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年12月05日 下午下午 5:28
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */
public class Singleton7 {


    private byte[] data = new byte[10242];

    private Singleton7() {
    }

    private enum EnumHolder {
        INSTANCE;

        private Singleton7 instance;

        EnumHolder() {
            this.instance = new Singleton7();
        }

        private Singleton7 getInstance() {
            return instance;
        }
    }

    public static Singleton7 getInstance() {
        return EnumHolder.INSTANCE.getInstance();
    }
}
