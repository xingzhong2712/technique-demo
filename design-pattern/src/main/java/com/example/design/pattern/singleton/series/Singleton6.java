package com.example.design.pattern.singleton.series;

/**
 * 类职责：<br/>
 *
 * <p>Title: Singleton6.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年12月05日 下午下午 5:26
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public final class Singleton6 {

    private byte[] data = new byte[1024];

    private Singleton6() {
    }

    private static class Holder {
        private static Singleton6 instance = new Singleton6();
    }

    public static Singleton6 getInstance() {
        return Holder.instance;
    }

}
