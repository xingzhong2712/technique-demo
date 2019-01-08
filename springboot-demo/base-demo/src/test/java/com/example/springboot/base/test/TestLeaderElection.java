package com.example.springboot.base.test;

import com.example.springboot.base.service.zookeeper.LeaderElection;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 类职责：<br/>
 *
 * <p>Title: TestLeaderElection.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2019年01月08日 下午下午 1:43
 * <p></p>
 * <p> </p>
 */
public class TestLeaderElection {

    @Test
    public void testLeaderElection() throws IOException, ExecutionException, InterruptedException {
        ZooKeeper zooKeeper = new ZooKeeper("", 2000, null);
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> futureList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            Callable<String> callable = new LeaderElection(zooKeeper, "", null);
            Future<String> future = executorService.submit(callable);

            futureList.add(future);
        }

        for (Future<String> future : futureList) {
            String leaderNode = future.get();
            if (!leaderNode.isEmpty()) {
                System.out.println("leader node is " + leaderNode);
            }
        }
    }

}
