package com.dynamic.threadPic.ch17;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-11-13
 * @description volatile可以保证可见性和有序性
 */
public class NoVisibility {
    private static volatile boolean ready;
    private static int number;

    public static class ReadThread extends Thread {
        @Override
        public void run() {
            while (!ready) ;
            System.out.println(number);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReadThread().start();
        Thread.sleep(1000);
        number = 42;
        ready = true;
        Thread.sleep(10000);
    }
}
