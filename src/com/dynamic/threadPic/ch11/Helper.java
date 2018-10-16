package com.dynamic.threadPic.ch11;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/10/16.20:44
 * @description 按照指定次数显示字符，真正的处理请求的功能
 */

public class Helper {
    public void handle(int count, char c) {
        System.out.println(" handle(" + count + ", " + c + ") BEGIN");
        for (int i = 0; i < count; i++) {
            slow();
            System.out.print(c);
        }
        System.out.println("");
        System.out.println(" handle(" + count + ", " + c + ") END");

    }

    public void slow() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {

        }
    }
}
