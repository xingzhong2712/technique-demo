package com.example.design.pattern.proxy.impl;

import com.example.design.pattern.proxy.IDBQuery;

import java.util.concurrent.TimeUnit;

/**
 * 类职责：<br/>
 *
 * <p>Title: DBQueryImpl.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月06日 下午下午 6:26
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class DBQueryImpl implements IDBQuery {

    public DBQueryImpl(){
        System.out.println("init a proxy instance");
//            Thread.sleep(1000);
    }

    @Override
    public String request() {
        return "request string";
    }

}
