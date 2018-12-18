package com.example.design.pattern.singleton;

import org.junit.Test;

public class SingletonDemo1Test {

    @Test
    public void testSingleton1(){
        SingletonDemo1.createAString();
    }

    @Test
    public void testSingleton2(){
        SingletonDemo2.createAString();
    }

    @Test
    public void testSingleton4(){
        SingletonDemo4.getInstance();
    }

}