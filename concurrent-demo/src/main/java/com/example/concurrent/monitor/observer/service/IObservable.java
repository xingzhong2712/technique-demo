package com.example.concurrent.monitor.observer.service;

/**
 * 类职责：<br/>
 *
 * <p>Title: IObservable.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年12月07日 下午下午 4:32
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */
public interface IObservable {

    /**任务生命周期*/
    enum Cycle{
        STARTED, RUNNING, DONE, ERROR
    }

    /**
     * 获取当前任务的生命周期状态
     * @return
     */
    Cycle getCycle();

    /**
     * 定义启动线程的方法，主要作用是为了屏蔽Thread的其他方法
     */
    void start();

    /**
     * 定义线程的打断方法，作用与start方法一样，也是为了屏蔽Thread的其他方法
     */
    void interrupt();

}
