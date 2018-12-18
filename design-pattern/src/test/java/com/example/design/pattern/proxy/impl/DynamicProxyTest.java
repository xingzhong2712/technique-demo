package com.example.design.pattern.proxy.impl;

import com.example.design.pattern.proxy.IDBQuery;
import org.junit.Test;

/**
 * 类职责：<br/>
 *
 * <p>Title: DynamicProxyTest.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月09日 下午上午 9:48
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class DynamicProxyTest {

    @Test
    public void testDynPro() {
        IDBQuery idbQuery = null;
        long begin = System.currentTimeMillis();
        idbQuery = jdkPro();
        long end = System.currentTimeMillis();
        System.out.println("create JDK Proxy time is " + (end - begin));

        begin = System.currentTimeMillis();
        for (int i = 0; i < 10000;i++){
            idbQuery.request();
        }
        System.out.println("call JDK Proxy time is " + (System.currentTimeMillis() - begin));
        begin = System.currentTimeMillis();
        idbQuery = cglibPro();
        end = System.currentTimeMillis();
        System.out.println("create CGLib Proxy time is " + (end - begin));
        begin = System.currentTimeMillis();
        for (int i = 0; i < 10000;i++){
            idbQuery.request();
        }
        System.out.println("call CGLib Proxy time is " + (System.currentTimeMillis() - begin));
    }

    IDBQuery jdkPro() {
        return JdkDBQueryHandler.createJdkProxy();
    }

    IDBQuery cglibPro() {
        return CGLibDBQueryInterceptor.createCGLibProxy();
    }

}
