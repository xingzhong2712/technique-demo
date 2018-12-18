package com.example.io.buffer;

import java.io.*;

/**
 * 类职责：<br/>
 *
 * <p>Title: ContainBuffer.java</p>
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

public class ContainBuffer {
    public static void writeFile() throws IOException {
        Writer writer = new BufferedWriter(new FileWriter(new File("E:/workspace/test-file/file.txt")));
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            writer.write(i);
        }

        writer.close();
        long end = System.currentTimeMillis();
        System.out.println("contain buffer spend time is " + (end - begin));
    }
}
