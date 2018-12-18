package com.example.pool.object;

/**
 * 类职责：<br/>
 *
 * <p>Title: ObjectPool.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月09日 下午下午 2:56
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */
public interface ObjectPool<T> {
    T borrowObject();

    void returnObject(T borrowed);
}
