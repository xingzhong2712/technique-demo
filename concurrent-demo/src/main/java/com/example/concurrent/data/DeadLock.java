package com.example.concurrent.data;

/**
 * 类职责：程序死锁<br/>
 *
 * <p>Title: DeadLock.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月18日 下午下午 1:39
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class DeadLock {

    public static void main(String[] args) {
        final DeadLock deadLock = new DeadLock();

        new Thread(()->{
            while (true){
                deadLock.read();
            }
        }, "READ-Thread").start();

        new Thread(()->{
            while (true){
                deadLock.write();
            }
        }, "WRITE-Thread").start();
    }

    private final Object MUTEX_READ = new Object();
    private final Object MUTEX_WRITE = new Object();

    public void read(){
        synchronized (MUTEX_READ){
            System.out.println(Thread.currentThread().getName() + " get READ lock");

            synchronized (MUTEX_WRITE){
                System.out.println(Thread.currentThread().getName() + " get WRITE lock");
            }

            System.out.println(Thread.currentThread().getName() + " release WRITE lock");
        }
        System.out.println(Thread.currentThread().getName() + " release READ lock");
    }

    public void write(){
        synchronized (MUTEX_WRITE){
            System.out.println(Thread.currentThread().getName() + " get WRITE lock");

            synchronized (MUTEX_READ){
                System.out.println(Thread.currentThread().getName() + " get READ lock");
            }

            System.out.println(Thread.currentThread().getName() + " release READ lock");
        }
        System.out.println(Thread.currentThread().getName() + " release WRITE lock");
    }
}
