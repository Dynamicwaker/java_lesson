package com.dynamic.threadPic.ch01;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/9/27.22:03
 * @description 线程测试类
 */

public class Main {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        // 启动新线程时调用的是start方法，而不是run方法，调用start方法后，程序会开启新的线程
        // 由这个新线程去调用run方法
        // start()方法的作用：1. 启动新的线程 2. 调用run方法
        // 需要理解两个概念：1. 并行：同时做两件事， 2. 并发：在两件事上切换，就像cpu一样，某个时间点来看，只是在做一件事
        myThread.start();
        for (int i = 0; i < 10000; i++) {
            System.out.println("Nice!");
        }
    }
}
