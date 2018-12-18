package com.example.concurrent.singlethreadexecution.demo;

/**
 * 类职责：<br/>
 *
 * <p>Title: Tableware.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年12月11日 下午下午 2:03
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class Tableware {
    /**
     * 餐具名称
     */
    private final String toolName;

    public Tableware(String toolName) {
        this.toolName = toolName;
    }

    @Override
    public String toString() {
        return "Tool: " + toolName;
    }
}
