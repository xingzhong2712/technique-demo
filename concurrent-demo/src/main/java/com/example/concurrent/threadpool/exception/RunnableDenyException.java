package com.example.concurrent.threadpool.exception;

/**
 * 类职责：<br/>
 *
 * <p>Title: RunnableDenyException.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年08月20日 下午下午 2:38
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class RunnableDenyException extends RuntimeException {

    public RunnableDenyException(String message) {
        super(message);
    }

}
