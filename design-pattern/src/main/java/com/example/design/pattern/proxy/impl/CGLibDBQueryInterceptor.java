package com.example.design.pattern.proxy.impl;

import com.example.design.pattern.proxy.IDBQuery;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 类职责：<br/>
 *
 * <p>Title: CGLibDBQueryInterceptor.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月06日 下午下午 7:01
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class CGLibDBQueryInterceptor implements MethodInterceptor {

    IDBQuery real = null;

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if (real == null){
            real = new DBQueryImpl();
        }
        return real.request();
    }

    public static IDBQuery createCGLibProxy(){
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(new CGLibDBQueryInterceptor());
        enhancer.setInterfaces(new Class[]{IDBQuery.class});

        IDBQuery cglibProxy = (IDBQuery) enhancer.create();

        return cglibProxy;
    }
}
