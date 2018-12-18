package com.example.concurrent.threadpool;

import com.example.concurrent.threadpool.exception.RunnableDenyException;

/**
 * 类职责：<br/>
 *
 * <p>Title: IDenyPolicy.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年08月20日 下午下午 2:33
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */
@FunctionalInterface
public interface IDenyPolicy {

    /**
     * queue达到上线，如何拒绝调用者
     *
     * @param runnable
     * @param threadPool
     */
    void reject(Runnable runnable, IThreadPool threadPool);

    class DiscardDenyPolicy implements IDenyPolicy {

        @Override
        public void reject(Runnable runnable, IThreadPool threadPool) {

        }
    }

    class AbortDenyPolicy implements IDenyPolicy {

        @Override
        public void reject(Runnable runnable, IThreadPool threadPool) {
            throw new RunnableDenyException("The runnable " + runnable + " will be abort .");
        }
    }

    class RunnerDenyPolicy implements IDenyPolicy {

        @Override
        public void reject(Runnable runnable, IThreadPool threadPool) {
            if (!threadPool.isShutdown()) {
                runnable.run();
            }
        }
    }

}
