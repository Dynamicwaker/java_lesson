package com.dynamic.interview.pattern.decorator;

/**
 * @author xinghuajian
 * @description
 * @date 2019/10/21 16:42
 */
public class PacketHTMLHeaderCreator extends PacketDecorator {

    public PacketHTMLHeaderCreator(IPacketCreator c) {
        super(c);
    }

    @Override
    public String handleContext() {
        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        sb.append("<body>");
        sb.append(compent.handleContext());
        sb.append("</body>");
        sb.append("</html>\n");
        return sb.toString();
    }
}
