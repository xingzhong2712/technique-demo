package com.technique.example.reflect.demo;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * 类职责：<br/>
 *
 * <p>Title: PropertyDescriptorTest.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月03日 下午上午 9:25
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class PropertyDescriptorTest {

    private void getFieldValue(Object object, String field){
        Class<? extends Object> clazz  = object.getClass();
        PropertyDescriptor pd = null;
        Method getMethod = null;
        try {
            pd = new PropertyDescriptor(field, clazz);
            if (null != pd) {
                // 获取  这个 field 属性 的get方法
                getMethod = pd.getReadMethod();
                Object invoke = getMethod.invoke(object);
                System.out.println(invoke);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private <T> void getFieldValues(T tarObj){

    }

}
