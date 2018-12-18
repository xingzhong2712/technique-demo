package com.example.java8.date;

import java.text.ParsePosition;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;
import java.util.Calendar;

/**
 * 类职责：<br/>
 *
 * <p>Title: LocalDateDemo.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年09月19日 下午下午 2:02
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class LocalDateDemo {
    public static void main(String[] args) {
        /*LocalDate today = LocalDate.now();
        System.out.println("今天的日期：" + today);

        LocalTime time = LocalTime.now();
        System.out.println("今天的时间：" + time);*/

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("今天的时间：" + dateTime);

        ZonedDateTime currentZonedDateTime = ZonedDateTime.now();
        System.out.println("current zone time : " + currentZonedDateTime.toLocalDateTime());
//        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("+7"));

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        System.out.println();
        LocalDateTime localDateTime = LocalDateTime.from(dtf.parse("20/09/2018 13:14"));

//        ZonedDateTime zonedDateTime  = ZonedDateTime.from(localDateTime);
        ZonedDateTime zonedDateTime2 = ZonedDateTime.of(localDateTime, ZoneId.of("+7"));

        System.out.println("+7      zone time : " + zonedDateTime2.toLocalDateTime());
        System.out.println("+7      zone      : " + zonedDateTime2.getZone());


        /*ZonedDateTime zonedDateTime3  = ZonedDateTime.of(zonedDateTime2.toLocalDateTime(), ZoneId.systemDefault());
        System.out.println("default zone time : " + zonedDateTime3.toLocalDateTime());*/
        ZonedDateTime zonedDateTime37 = zonedDateTime2.withZoneSameInstant(ZoneId.systemDefault());
        System.out.println("default zone time 37: " + zonedDateTime37.toLocalDateTime());

        LocalDateTime localDateTime37 = zonedDateTime37.toLocalDateTime();
        localDateTime37 = localDateTime37.minusMinutes(20);
        System.out.println("localDateTime37 :" + localDateTime37);
        localDateTime37 = localDateTime37.minusHours(6);
        System.out.println("localDateTime37 :" + localDateTime37);


        ZonedDateTime zonedDateTime39 = zonedDateTime2.toLocalDateTime().atZone(ZoneId.systemDefault());
        System.out.println("default zone time 39: " + zonedDateTime39.toLocalDateTime());


        ZonedDateTime zonedDateTime4 = ZonedDateTime.now(ZoneId.of("+7"));
        System.out.println("+7      zone time : " + zonedDateTime4.toLocalDateTime());
        /*ZonedDateTime zonedDateTime = ZonedDateTime.from(dtf.parse("20/09/2018 13:14"));
        System.out.println("+7 zone time : " + zonedDateTime);
        System.out.println("+7 zone time : " + zonedDateTime.toLocalDateTime());*/

    }
}
