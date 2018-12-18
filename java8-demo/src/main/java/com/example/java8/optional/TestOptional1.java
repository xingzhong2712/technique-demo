package com.example.java8.optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 类职责：<br/>
 *
 * <p>Title: TestOptional1.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月19日 下午下午 3:14
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class TestOptional1 {
    public static void main(String[] args) {
        Map testMap = new HashMap();
        testMap.put("name", "seen");
        Optional name = Optional.of(testMap);
        if (name.isPresent()) {
            System.out.println(name.get());
        }


        name.ifPresent(System.out::println);
        name.ifPresent((value) -> System.out.println("The length of the value is " + value));
    }
}
