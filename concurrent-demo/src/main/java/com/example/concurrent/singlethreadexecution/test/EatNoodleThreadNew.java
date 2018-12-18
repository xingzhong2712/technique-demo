package com.example.concurrent.singlethreadexecution.test;

import com.example.concurrent.singlethreadexecution.demo.Tableware;
import com.example.concurrent.singlethreadexecution.demo.TablewarePair;

/**
 * 类职责：<br/>
 *
 * <p>Title: EatNoodleThread.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年12月11日 下午下午 2:04
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class EatNoodleThreadNew extends Thread {

    public static void main(String[] args) {
        Tableware fork = new Tableware("fork");
        Tableware knife = new Tableware("knife");
        TablewarePair pairA = new TablewarePair(fork, knife);
        TablewarePair pairB = new TablewarePair(knife, fork);

        new EatNoodleThreadNew("A", pairA).start();
        new EatNoodleThreadNew("B", pairB).start();
    }


    private final String name;

    private final TablewarePair tablewarePair;

    public EatNoodleThreadNew(String name, TablewarePair tablewarePair) {
        this.name = name;
        this.tablewarePair = tablewarePair;
    }

    @Override
    public void run() {
        while (true) {
            this.eat();
        }
    }

    private void eat() {
        synchronized (tablewarePair) {
            System.out.println(name + " take up " + tablewarePair.getLeftTool() + "(left)");
            System.out.println(name + " take up " + tablewarePair.getRightTool() + "(right)");
            System.out.println(name + " is eating now. ");
            System.out.println(name + " put down " + tablewarePair.getRightTool() + "(right)");
            System.out.println(name + " put down " + tablewarePair.getLeftTool() + "(left)");
        }
    }
}
