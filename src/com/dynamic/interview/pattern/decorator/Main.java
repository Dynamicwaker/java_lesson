package com.dynamic.interview.pattern.decorator;

/**
 * @author xinghuajian
 * @description 装饰者模式
 * @date 2019/10/21 16:50
 */
public class Main {
    public static void main(String[] args) {
        IPacketCreator pc = new PacketHTTPHeaderCreator(
                new PacketHTMLHeaderCreator(
                        new PacketBodyCreator()));
        System.out.println(pc.handleContext());
    }
}
