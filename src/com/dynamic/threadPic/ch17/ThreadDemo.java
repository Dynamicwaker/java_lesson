package com.dynamic.threadPic.ch17;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-10-27
 * @description 1、主线程和线程run方法打印内容交叉执行，说明线程是并行的，
 * 2、线程的运行时抢占式的，所以有的主线程循环了多次才到另一个线程
 */
public class ThreadDemo {
    public static void main(String[] args) {
        // 创建一个线程对象,覆盖其run方法，传入参数作为线程的名字
        Thread thread = new Thread() {
            @Override
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    System.out.println("自定义线程循环：" + i);
                }
            }
        };
        // 调用线程
        thread.start();
        for (int i = 1; i <= 100; i++) {
            System.out.println("主线程循环：" + i);
        }
    }
}
