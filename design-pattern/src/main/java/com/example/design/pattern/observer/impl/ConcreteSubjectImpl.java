package com.example.design.pattern.observer.impl;

import com.example.design.pattern.observer.IObserver;
import com.example.design.pattern.observer.ISubject;
import javafx.event.Event;

import java.awt.*;
import java.util.Vector;

/**
 * 类职责：<br/>
 *
 * <p>Title: ConcreteSubjectImpl.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月09日 下午下午 1:53
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class ConcreteSubjectImpl implements ISubject {

    Vector<IObserver> observers = new Vector<>();

    @Override
    public void attach(IObserver observer) {
        observers.addElement(observer);
    }

    @Override
    public void detach(IObserver observer) {
        observers.removeElement(observer);
    }

    @Override
    public void inform() {
        System.out.println("update");
    }
}
