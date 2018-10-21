package com.dynamic.threadPic.ch14;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-10-20
 * @description Two-Phase Termination模式，分两阶段终止
 * 1. 安全的终止线程(安全性)
 * 2. 必定会进行安全处理(生存性)
 * 3. 发出终止请求后尽快进行终止处理(响应性)
 *  Main 请求发送者
 *  不能使用Thread的stop方法，因为stop方法，实例的安全性就无法确保，因为即使是正在执行的synchronized方法也会被终止
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("main:BEGIN");
        try {
            // 启动线程
            CountupThread t = new CountupThread();
            t.start();

            // 稍微间隔一段时间
            Thread.sleep(10000);

            // 线程的终止请求
            System.out.println("main: shutdownRequest");
            t.shutdownRequest();

            System.out.println("main:join");
            // 等待线程的终止的方法，在指定线程终止前，join方法不会返回，可以用来判断线程的终止
            // Thread的isAlive可以确认线程是否已经终止（true/false）
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main:END");
    }
}
