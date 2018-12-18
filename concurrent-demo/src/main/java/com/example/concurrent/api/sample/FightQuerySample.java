package com.example.concurrent.api.sample;

import com.example.concurrent.api.sample.impl.FightQueryTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 类职责：<br/>
 *
 * <p>Title: FightQuerySample.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月10日 下午下午 6:33
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class FightQuerySample {

    private static List<String> fightCompany = Arrays.asList("CSA", "CEA", "HNA");

    public static void main(String[] args) {
        List<String> results = search("HZ", "TY");
        System.out.println("====================result====================");
        results.forEach(System.out::println);

    }

    private static List<String> search(String original, String dest) {
        final List<String> result = new ArrayList<>();

        //创建查询航班信息的线程列表
        List<FightQueryTask> tasks = fightCompany.stream().map(f -> createSearchTask(f, original, dest)).collect(Collectors.toList());

        //分别调用每一个线程的join方法，阻塞当前线程
        tasks.forEach(Thread::start);
        tasks.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        //在此之前，当前线程会阻塞住，获取每一个查询线程的结果，并且 加入到result中
        tasks.stream().map(FightQueryTask::get).forEach(result::addAll);

        return result;
    }

    private static FightQueryTask createSearchTask(String fight, String original, String dest) {
        return new FightQueryTask(fight, original, dest);
    }

}
