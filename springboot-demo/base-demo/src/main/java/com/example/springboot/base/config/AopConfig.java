package com.example.springboot.base.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * 类职责：<br/>
 *
 * <p>Title: AopConfig.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2019年01月07日 下午上午 10:35
 * <p></p>
 * <p> </p>
 */
@Configuration
@Aspect
public class AopConfig {

    @Around("@within(org.springframework.stereotype.Controller)")
    public Object simpleAop(final ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            Object[] args = joinPoint.getArgs();
            System.out.println("args: " + Arrays.asList(args));

            // 调用原有方法
            Object object = joinPoint.proceed();
            System.out.println("return: " + object);
            return object;
        } catch (Throwable throwable) {
            throw throwable;
        }
    }
}
