package com.example.other.test.other;

import java.util.Date;

/**
 * 类职责：<br/>
 *
 * <p>Title: StringToDateTest.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年12月12日 下午上午 10:59
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class StringToDateTest {
    public static void main(String[] args) {
        String timestamp = "1544670335889";
        Date date = new Date(Long.valueOf(timestamp));

        System.out.println(date);
    }
}
