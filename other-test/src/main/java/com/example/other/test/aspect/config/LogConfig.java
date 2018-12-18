package com.example.other.test.aspect.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 类职责：<br/>
 *
 * <p>Title: LogConfig.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年10月26日 下午上午 9:53
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */
@Aspect
@Component
public class LogConfig {

    @Pointcut()
    public void execute(){}

}
