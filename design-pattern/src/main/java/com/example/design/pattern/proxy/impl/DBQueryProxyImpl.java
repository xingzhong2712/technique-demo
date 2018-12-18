package com.example.design.pattern.proxy.impl;

import com.example.design.pattern.proxy.IDBQuery;

/**
 * 类职责：<br/>
 *
 * <p>Title: DBQueryProxyImpl.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月06日 下午下午 6:30
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class DBQueryProxyImpl implements IDBQuery {

    private DBQueryImpl real = null;

    @Override
    public String request() {
        if (real == null) {
            real = new DBQueryImpl();
        }

        return real.request();
    }

}
