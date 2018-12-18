package com.technique.example.distribute.demo.hazelcast.server;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import java.util.Map;
import java.util.Queue;

/**
 * 类职责：<br/>
 *
 * <p>Title: HazelcastGetStartServerSlave.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年06月22日 下午下午 3:43
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class HazelcastGetStartServerSlave {

    public static void main(String[] args){
        //创建一个 hazelcastInstance实例
        HazelcastInstance instance = Hazelcast.newHazelcastInstance();
        Map<Integer, String> clusterMap = instance.getMap("MyMap");
        Queue<String> clusterQueue = instance.getQueue("MyQueue");

        System.out.println("Map Value:" + clusterMap.get(1));
        System.out.println("Queue Size :" + clusterQueue.size());
        System.out.println("Queue Value 1:" + clusterQueue.poll());
        System.out.println("Queue Value 2:" + clusterQueue.poll());
        System.out.println("Queue Size :" + clusterQueue.size());
    }

}
