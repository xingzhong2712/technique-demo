package com.example.other.test.collection;

import java.util.HashMap;

/**
 * 类职责：<br/>
 *
 * <p>Title: MapTests.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年09月21日 下午下午 2:24
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class MapTests {

    public static void main(String[] args) {
        HashMap hashMap = new HashMap();

        hashMap.put("a","111");
        hashMap.put("b","222");
        hashMap.put("c","333");
        hashMap.put("d","444");

        Object[]objects = hashMap.values().toArray();
        System.out.println(objects);
        for (Object o :objects){
            System.out.println(o);
        }

    }
}
