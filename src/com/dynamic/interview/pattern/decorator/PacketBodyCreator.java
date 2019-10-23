package com.dynamic.interview.pattern.decorator;

/**
 * @author xinghuajian
 * @description
 * @date 2019/10/21 16:38
 */
public class PacketBodyCreator implements IPacketCreator {

    @Override
    public String handleContext() {
        return "Content of Packet";
    }
}
