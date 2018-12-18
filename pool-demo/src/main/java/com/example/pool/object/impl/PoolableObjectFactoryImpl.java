package com.example.pool.object.impl;

import com.example.pool.object.PoolableObjectFactory;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 类职责：<br/>
 *
 * <p>Title: PoolableObjectFactoryImpl.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月09日 下午下午 3:03
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class PoolableObjectFactoryImpl implements PoolableObjectFactory {

    private static AtomicInteger counter = new AtomicInteger(0);

    @Override
    public Object makeObject() {
        Object obj = String.valueOf(counter.getAndIncrement());
        System.out.println("create object " + obj);

        return obj;
    }

    @Override
    public void activateObject(Object obj) {
        System.out.println("before borrow " + obj);
    }

    @Override
    public void passivateObject(Object obj) {
        System.out.println("return " + obj);
    }

    @Override
    public boolean validateObject(Object obj) {
        return true;
    }

    @Override
    public void destroyObject(Object obj) {
        System.out.println("destroying object " + obj);
    }

}
