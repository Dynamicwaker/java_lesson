package com.dynamic.threadPic.ch17.producer_consumer;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/11/24.11:37
 * @description 作为生产者和消费者之间的共享数据模型
 */

public final class PCData {
    private final int intData;

    public PCData(int data) {
        intData = data;
    }

    public PCData(String d) {
        intData = Integer.valueOf(d);
    }

    public int getData() {
        return intData;
    }

    @Override
    public String toString() {
        return "data:" + intData;
    }


}
