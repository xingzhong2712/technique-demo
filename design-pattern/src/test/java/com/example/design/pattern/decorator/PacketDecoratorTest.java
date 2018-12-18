package com.example.design.pattern.decorator;

import com.example.design.pattern.decorator.impl.PacketBodyCreatorImpl;
import org.junit.Test;

public class PacketDecoratorTest {

    @Test
    public void testDecorator() {
        IPacketCreator packetCreator = new PacketHTTPHeaderCreator(new PacketHTMLHeaderCreator(new PacketBodyCreatorImpl()));

        System.out.println(packetCreator.handleContent());
    }

}