package com.example.pool.object;

import com.example.pool.object.impl.PoolableObjectFactoryImpl;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 类职责：<br/>
 *
 * <p>Title: ObjectPoolTest.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月09日 下午下午 3:07
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class ObjectPoolTest {

    static PoolableObjectFactory factory = new PoolableObjectFactoryImpl();

    static ObjectPool pool = (ObjectPool) new GenericObjectPool((PooledObjectFactory) factory);

    private static AtomicInteger endcount = new AtomicInteger(0);

    public static class PoolThread extends Thread {

        @Override
        public void run() {
            Object obj = null;

            try {
                for (int i = 0; i < 100; i++) {
                    System.out.println("==" + i + "==");

                    obj = pool.borrowObject();
                    System.out.println(obj + " is get .");
                    pool.returnObject(obj);
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                endcount.getAndIncrement();
            }
        }
    }

    public static void main(String args[]){
        new PoolThread().start();
        new PoolThread().start();
        new PoolThread().start();

        try {
            while (true){
                if (endcount.get() == 4){
                    System.out.println("loop end .");
                    break;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
