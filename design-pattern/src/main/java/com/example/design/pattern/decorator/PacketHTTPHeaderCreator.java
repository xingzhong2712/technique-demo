package com.example.design.pattern.decorator;

/**
 * 类职责：<br/>
 *
 * <p>Title: PacketHTTPHeaderCreator.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月09日 下午上午 10:52
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class PacketHTTPHeaderCreator extends PacketDecorator {
    public PacketHTTPHeaderCreator(IPacketCreator iPacketCreator) {
        super(iPacketCreator);
    }

    @Override
    public String handleContent() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cache-Control:no-cache\n");
        sb.append("Date:Mon,21Dec201810:53:43GMT\n");
        sb.append(component.handleContent());

        return sb.toString();
    }
}
