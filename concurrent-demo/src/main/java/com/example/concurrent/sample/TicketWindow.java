package com.example.concurrent.sample;

/**
 * 类职责：<br/>
 *
 * <p>Title: TicketWindow.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月09日 下午下午 6:19
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class TicketWindow extends Thread {

    private String name = "";
    private static final int MAX = 50;
    private static int index = 1;

    public TicketWindow(String name) {
        this.name = name;
    }

    public static void main(String args[]){
        TicketWindow t1 = new TicketWindow("一号出号机");
        t1.start();
        TicketWindow t2 = new TicketWindow("二号出号机");
        t2.start();
        TicketWindow t3 = new TicketWindow("三号出号机");
        t3.start();
        TicketWindow t4 = new TicketWindow("四号出号机");
        t4.start();
    }

    @Override
    public void run() {
        while (index <= MAX) {
            System.out.println("柜台：" + name + " 当前的号码是：" + (index++));
        }
    }
}
