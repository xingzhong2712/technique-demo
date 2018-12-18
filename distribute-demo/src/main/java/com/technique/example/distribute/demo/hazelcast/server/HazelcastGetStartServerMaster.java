package com.technique.example.distribute.demo.hazelcast.server;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import java.util.Map;
import java.util.Queue;

/**
 * 类职责：<br/>
 *
 * <p>Title: HazelcastGetStartServerMaster.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年06月22日 下午下午 3:24
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class HazelcastGetStartServerMaster {

    public static void main(String[] args) {
        HazelcastInstance instance = Hazelcast.newHazelcastInstance();

        Map<Integer, String> clusterMap = instance.getMap("MyMap");

        clusterMap.put(1,"Hello hazelcast map !");

        //
        Queue<String> clusterQueue = instance.getQueue("MyQueue");
        clusterQueue.offer("Hello hazelcast !");
        clusterQueue.offer("Hello hazelcast queue!");
    }

}
