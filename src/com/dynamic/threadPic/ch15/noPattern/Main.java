package com.dynamic.threadPic.ch15.noPattern;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-10-22
 * @description Thread-Specific Storage模式，即使入口只有一个，也会在内部为每个线程分配特有的存储空间的模式
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("MAIN BEGIN");
        for (int i = 0; i < 10; i++) {
            Log.println("main: i = " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {

            }
        }
        Log.close();
        System.out.println("MAIN END");
    }
}
