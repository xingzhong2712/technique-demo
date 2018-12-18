package com.example.io.buffer;

import org.junit.Test;

import java.io.IOException;

/**
 * 类职责：<br/>
 *
 * <p>Title: BufferTest.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月09日 下午下午 2:23
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class BufferTest {

    @Test
    public void testBuffer() throws IOException {
        NoBuffer.writeFile();

        ContainBuffer.writeFile();
    }

}
