package com.example.design.pattern.observer;

import javafx.event.Event;

/**
 * 类职责：<br/>
 *
 * <p>Title: IObserver.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月09日 下午上午 11:28
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public interface IObserver {

    void update(Event event);
}
