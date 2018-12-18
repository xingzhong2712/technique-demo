package com.example.design.pattern.decorator;

/**
 * 类职责：<br/>
 *
 * <p>Title: PacketDecorator.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月09日 下午上午 10:46
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public abstract class PacketDecorator implements IPacketCreator{

    IPacketCreator component;

    public PacketDecorator(IPacketCreator iPacketCreator){
        component = iPacketCreator;
    }
}
