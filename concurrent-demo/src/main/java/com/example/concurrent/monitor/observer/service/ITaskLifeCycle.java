package com.example.concurrent.monitor.observer.service;

/**
 * 类职责：<br/>
 *
 * <p>Title: ITaskLifeCycle.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年12月07日 下午下午 4:37
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */
public interface ITaskLifeCycle<T> {

    /**
     * 任务启动
     *
     * @param thread
     */
    void onStart(Thread thread);

    /**
     * 正在运行
     *
     * @param thread
     */
    void onRunning(Thread thread);

    /**
     * 任务结束
     *
     * @param thread
     * @param result
     */
    void onFinish(Thread thread, T result);

    /**
     * 任务报错
     *
     * @param thread
     * @param e
     */
    void onError(Thread thread, Exception e);

    class EmptyLifeCycle<T> implements ITaskLifeCycle{
        @Override
        public void onStart(Thread thread) {

        }

        @Override
        public void onRunning(Thread thread) {

        }

        @Override
        public void onFinish(Thread thread, Object result) {

        }

        @Override
        public void onError(Thread thread, Exception e) {

        }
    }

}
