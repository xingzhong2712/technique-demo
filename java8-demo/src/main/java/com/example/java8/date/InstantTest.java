package com.example.java8.date;

import java.time.Instant;

/**
 * 类职责：<br/>
 *
 * <p>Title: InstantTest.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年09月25日 下午下午 5:35
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class InstantTest {
    public static void main(String[] args) {
        System.out.println("现在的时间戳：" + Instant.now());
        System.out.println("现在的时间戳：" + Instant.now().getEpochSecond());
        System.out.println("现在的时间戳：" + Instant.now().toEpochMilli());
        System.out.println("现在的时间戳：" + System.currentTimeMillis());
    }
}
