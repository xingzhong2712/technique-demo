package com.example.concurrent.monitor;

import com.example.concurrent.monitor.observer.ObservableThread;
import com.example.concurrent.monitor.observer.service.IObservable;
import com.example.concurrent.monitor.observer.service.ITaskLifeCycle;

import java.util.concurrent.TimeUnit;

/**
 * 类职责：<br/>
 *
 * <p>Title: ObserverTest.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年12月07日 下午下午 5:07
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class ObserverTest2 {

    public static void main(String[] args) {
        final ITaskLifeCycle<String> lifeCycle = new ITaskLifeCycle.EmptyLifeCycle<String>() {
            @Override
            public void onFinish(Thread thread, Object result) {
                System.out.println("The result is " + result);
            }
        };

        IObservable observable = new ObservableThread<>(lifeCycle, () -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(" finished done. ");
            return "Hello Observer. ";
        });

        observable.start();
    }

}
