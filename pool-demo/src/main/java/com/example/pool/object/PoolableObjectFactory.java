package com.example.pool.object;

/**
 * 类职责：<br/>
 *
 * <p>Title: PoolableObjectFactory.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月09日 下午下午 2:58
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */
public interface PoolableObjectFactory<T> {
    T makeObject();
    void activateObject(T obj);
    void passivateObject(T obj);
    boolean validateObject(T obj);
    void destroyObject(T obj);
}
