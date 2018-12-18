package com.example.java8.date;

import java.util.Calendar;
import java.util.TimeZone;

/**
 * 类职责：<br/>
 *
 * <p>Title: CalendarTest.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年09月19日 下午下午 3:39
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class CalendarTest {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        System.out.println("当前时区时间为：" + c.getTime());
        System.out.println("当前时区为：" + c.getTimeZone());
        c.setTimeZone(TimeZone.getTimeZone("GMT+07:00"));
        System.out.println("当前时区为：" + c.getTimeZone());
        Calendar c2 = Calendar.getInstance();
        c2.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE), c.get(Calendar.HOUR), c.get(Calendar.MINUTE));
        System.out.println("+7时区时间为：" + c2.getTime());
        System.out.println("当前时区为：" + c2.getTimeZone());
    }
}
