package com.dynamic.threadPic.ch13;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-10-18
 * @description 表示实际数据的类
 */
public class RealData implements Data {
    private final String content;

    public RealData(int count, char c) {
        System.out.println(" making RealData(" + count + ", " + c + ") BEGIN");
        char[] buffer = new char[count];
        for (int i = 0; i < count; i++) {
            buffer[i] = c;
            // 实际数据的操作生成是比较耗时的，先模拟一下
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {

            }
        }
        System.out.println(" making RealData(" + count + ", " + c + ") END");
        this.content = new String(buffer);
    }

    @Override
    public String getContent() {
        return content;
    }
}
