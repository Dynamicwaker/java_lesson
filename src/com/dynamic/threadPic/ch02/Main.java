package com.dynamic.threadPic.ch02;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/10/1.22:52
 * @description 运行结果中有的数据结束的节点并不正确，是因为在某个线程在执行check方法时，name和address被其他线程改写了
 * Single Thread Execution单线程执行模式，gate是共享资源
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("Testing Gate,hit CTRL+R to exit");
        Gate gate = new Gate();
        new UserThread(gate, "Alice", "Alaska").start();
        new UserThread(gate, "Bobby", "Brazil").start();
        new UserThread(gate, "Chris", "Canada").start();
    }
}
