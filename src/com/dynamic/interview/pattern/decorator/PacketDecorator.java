package com.dynamic.interview.pattern.decorator;

/**
 * @author xinghuajian
 * @description
 * @date 2019/10/21 16:39
 */
public abstract class PacketDecorator implements IPacketCreator {

    IPacketCreator compent;

    public PacketDecorator(IPacketCreator c) {
        this.compent = c;
    }
}
