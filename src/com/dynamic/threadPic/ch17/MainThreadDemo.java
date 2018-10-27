package com.dynamic.threadPic.ch17;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-10-27
 * @description 每个进程都是至少有一个线程，作为程序的入口，通常情况下这个线程为主线程
 */
public class MainThreadDemo {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
    }
}
