package com.dynamic.threadPic.ch12;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/10/16.21:18
 * @description Worker Thread模式，也叫线程池模式
 * 1. 提高吞吐量，取决于线程的启动时间
 * 2. 容量控制
 */

public class Main {
    public static void main(String[] args) {
        // 工人线程的个数
        Channel channel = new Channel(5);
        channel.startWorkers();
        new ClientThread("Alice",channel).start();
        new ClientThread("Bobby",channel).start();
        new ClientThread("Chris",channel).start();
    }



}
