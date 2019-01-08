package com.example.springboot.base.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 类职责：<br/>
 *
 * <p>Title: TestSpringBoot.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2019年01月07日 下午下午 5:46
 * <p></p>
 * <p> </p>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestSpringBoot extends AbstractJUnit4SpringContextTests {

    @Autowired
    private Environment env;

    // 1.
    public int getPort() {
        return env.getProperty("server.port", Integer.class);
    }


    @Test
    public void testSpringBoot() {
        System.out.println("env port: " + getPort());
    }
}
