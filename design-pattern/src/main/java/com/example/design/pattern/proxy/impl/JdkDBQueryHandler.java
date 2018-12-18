package com.example.design.pattern.proxy.impl;

import com.example.design.pattern.proxy.IDBQuery;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 类职责：<br/>
 *
 * <p>Title: JdkDBQueryHandler.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月06日 下午下午 6:55
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class JdkDBQueryHandler implements InvocationHandler {

    private IDBQuery idbQuery = null;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (idbQuery == null) {
            idbQuery = new DBQueryImpl();
        }

        return idbQuery.request();
    }

    public static IDBQuery createJdkProxy(){
        IDBQuery jdkProxy = (IDBQuery) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{IDBQuery.class}, new JdkDBQueryHandler());

        return jdkProxy;
    }


}
