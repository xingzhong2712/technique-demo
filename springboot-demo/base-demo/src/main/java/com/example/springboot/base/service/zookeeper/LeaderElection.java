package com.example.springboot.base.service.zookeeper;

import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * 类职责：模拟ZKLeader选举<br/>
 *
 * <p>Title: LeaderElection.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2019年01月08日 下午下午 1:21
 * <p></p>
 * <p> </p>
 */
@Slf4j
//@Service
public class LeaderElection implements Callable<String> {

    private ZooKeeper zooKeeper;
    private String znodePath;
    private String name;
    private String newNodeName;
    private boolean isLeader;

    public LeaderElection() {
    }

    public LeaderElection(ZooKeeper zooKeeper, String znodePath, String name) {
        this.zooKeeper = zooKeeper;
        this.znodePath = znodePath;
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        String fullPath = znodePath.concat("/queue-");
        newNodeName = zooKeeper.create(
                fullPath,
                this.name.getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.EPHEMERAL_SEQUENTIAL
        );
        log.info("[{}] created node: [{}]", this.name, this.newNodeName);

        List<String> nodeList = zooKeeper.getChildren(this.znodePath, false);
        isLeader = checkIsLeader(nodeList, newNodeName);
        log.info("[{}] is leader: [{}]", this.name, isLeader);

        if (!isLeader) {
            zooKeeper.delete(newNodeName, zooKeeper.exists(newNodeName, false).getVersion());
            return "";
        } else {
            return newNodeName;
        }
    }

    private boolean checkIsLeader(List<String> nodeList, String newNodeName) {
        int curValue = getNumber(newNodeName);
        for (String node : nodeList) {
            if (getNumber(node) < curValue) {
                return false;
            }
        }

        return true;
    }

    private int getNumber(String queueNode) {
        queueNode = queueNode.substring(queueNode.length() - 10);

        return Integer.parseInt(queueNode);
    }
}
