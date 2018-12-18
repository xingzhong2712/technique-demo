package com.example.concurrent.classloader.litedemo;

import java.util.Random;

/**
 * 类职责：<br/>
 *
 * <p>Title: GlobalConstants.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年09月21日 下午上午 11:51
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class GlobalConstants {

    static {
        System.out.println("The GlobalConstants will be init..");
    }

    public static final int MAX = 100;

    public static final int RANDOM = new Random().nextInt();

}
