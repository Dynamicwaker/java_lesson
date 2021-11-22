package com.dynamic.interview.pattern.decorator;

/**
 * @author xinghuajian
 * @description
 * @date 2019/10/21 16:46
 */
public class PacketHTTPHeaderCreator extends PacketDecorator {

    public PacketHTTPHeaderCreator(IPacketCreator c) {
        super(c);
    }

    @Override
    public String handleContext() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cache-Control:no-cache\n");
        sb.append("Date:Mon,31Dec201916:49:57GMT\n");
        sb.append(compent.handleContext());
        return sb.toString();
    }
}
