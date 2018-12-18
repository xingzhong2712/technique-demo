package com.example.concurrent.api;

import java.util.stream.IntStream;

/**
 * 类职责：<br/>
 *
 * <p>Title: ThreadYield.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月10日 下午上午 11:02
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class ThreadYield {

    public static void main(String[] args) {
        IntStream.range(0,2).mapToObj(ThreadYield::create).forEach(Thread::start);
    }

    private static Thread create(int index){
        return new Thread(()->{
            if (index == 0){
                Thread.yield();
            }

            System.out.println(index);
        });
    }

}
