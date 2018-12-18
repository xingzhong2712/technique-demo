package com.example.exception.test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * 类职责：<br/>
 *
 * <p>Title: TestException.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年12月05日 下午下午 3:05
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class TestException {
    public static void main(String[] args) {
        //语法try-with-resource：自动关闭Closeable的资源
        try (FileOutputStream outputStream = new FileOutputStream(new File(""));ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("test excetion".getBytes())){
            byteArrayInputStream.read();
            outputStream.write(new byte[1024]);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
