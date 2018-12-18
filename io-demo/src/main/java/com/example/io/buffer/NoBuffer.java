package com.example.io.buffer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * 类职责：<br/>
 *
 * <p>Title: NoBuffer.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月09日 下午下午 2:18
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class NoBuffer {

    public static void writeFile() throws IOException {
        Writer writer = new FileWriter(new File("E:/workspace/test-file/file.txt"));
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            writer.write(i);
        }

        writer.close();
        long end = System.currentTimeMillis();
        System.out.println("no buffer spend time is " + (end - begin));
    }
}
