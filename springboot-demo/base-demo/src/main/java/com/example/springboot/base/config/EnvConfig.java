package com.example.springboot.base.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * 类职责：获取application.properties中的值<br/>
 *
 * <p>Title: EnvConfig.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2019年01月07日 下午上午 11:56
 * <p></p>
 * <p> </p>
 */
@Data
@ConditionalOnBean
public class EnvConfig {

    @Autowired
    private Environment env;

    // 1.
    public int getPort() {
        return env.getProperty("server.port", Integer.class);
    }

    // 2.
    @Value("${server.port}")
    private int port;

    // 3.
    @ConfigurationProperties("server")
    @Configuration
    @Data
    private static class Config{
        private int port;
    }
}
