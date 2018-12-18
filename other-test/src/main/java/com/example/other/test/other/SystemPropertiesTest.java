package com.example.other.test.other;

/**
 * 类职责：<br/>
 *
 * <p>Title: SystemPropertiesTest.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年09月21日 下午下午 5:54
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class SystemPropertiesTest {

    public static void main(String[] args) {
        System.out.println(System.getProperties());
        String lineSeparator = System.getProperty("line.separator");
        System.out.println(lineSeparator);
    }

}
