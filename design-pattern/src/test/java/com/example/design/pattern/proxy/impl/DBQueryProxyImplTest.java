package com.example.design.pattern.proxy.impl;

import com.example.design.pattern.proxy.IDBQuery;
import org.junit.Test;

public class DBQueryProxyImplTest {

    @Test
    public void testProxy1(){
        IDBQuery idbQuery = new DBQueryProxyImpl();

        idbQuery.request();
    }

}