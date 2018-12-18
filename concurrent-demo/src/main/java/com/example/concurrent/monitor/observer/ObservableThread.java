package com.example.concurrent.monitor.observer;

import com.example.concurrent.monitor.observer.service.IObservable;
import com.example.concurrent.monitor.observer.service.ITask;
import com.example.concurrent.monitor.observer.service.ITaskLifeCycle;

/**
 * 类职责：<br/>
 *
 * <p>Title: ObservableThread.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年12月07日 下午下午 4:46
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class ObservableThread<T> extends Thread implements IObservable {

    private final ITaskLifeCycle<T> lifeCycle;

    private final ITask<T> task;

    private Cycle cycle;

    public ObservableThread(ITask<T> task) {
        this(new ITaskLifeCycle.EmptyLifeCycle<>(), task);
    }

    public ObservableThread(ITaskLifeCycle<T> lifeCycle, ITask<T> task) {
        super();
        if (task == null) {
            throw new IllegalArgumentException("The task is required.");
        }

        this.lifeCycle = lifeCycle;
        this.task = task;
    }

    @Override
    public final void run() {
        this.update(Cycle.STARTED, null, null);
        try {
            this.update(Cycle.RUNNING, null, null);
            T result = this.task.call();
            this.update(Cycle.DONE, result, null);
        } catch (Exception e) {
            this.update(Cycle.ERROR, null, e);
        }
    }

    private void update(Cycle cycle, T result, Exception e) {
        this.cycle = cycle;
        if (lifeCycle == null) {
            return;
        }
        try {
            switch (cycle) {
                case STARTED:
                    this.lifeCycle.onStart(currentThread());
                    break;
                case RUNNING:
                    this.lifeCycle.onRunning(currentThread());
                    break;
                case DONE:
                    this.lifeCycle.onFinish(currentThread(), result);
                    break;
                case ERROR:
                    this.lifeCycle.onError(currentThread(), e);
                    break;
                default:
            }
        } catch (Exception ex) {
            if (cycle == Cycle.ERROR) {
                throw ex;
            }
        }
    }

    @Override
    public Cycle getCycle() {
        return this.cycle;
    }
}
