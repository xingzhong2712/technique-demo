package com.example.java8.date;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

/**
 * 类职责：<br/>
 *
 * <p>Title: YearMonthTest.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年09月27日 下午下午 2:20
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class YearMonthTest {
    public static void main(String[] args) {
        YearMonth yearMonth1 = YearMonth.now();
        System.out.println("yearMonth1 is " + yearMonth1);
        System.out.println("year is " + yearMonth1.getYear());
        System.out.println("month is " + yearMonth1.getMonthValue());


        YearMonth yearMonth = YearMonth.parse("12/2018", DateTimeFormatter.ofPattern("MM/YY"));
        System.out.println("year and month is " + yearMonth);

        System.out.println("year is " + yearMonth.getYear());
        System.out.println("month is " + yearMonth.getMonth());
    }
}
