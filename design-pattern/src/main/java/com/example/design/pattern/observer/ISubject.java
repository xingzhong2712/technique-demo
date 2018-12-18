package com.example.design.pattern.observer;

/**
 * 类职责：<br/>
 *
 * <p>Title: ISubject.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月09日 下午上午 11:27
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */
public interface ISubject {

    void attach(IObserver observer);
    void detach(IObserver observer);
    void inform();

}
