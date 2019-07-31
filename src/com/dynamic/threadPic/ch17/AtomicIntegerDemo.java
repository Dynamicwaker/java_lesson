package com.dynamic.threadPic.ch17;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-11-20
 * @description 无锁的线程安全整数AtomicInteger ,CAS策略（比较交换）的实现
 */
public class AtomicIntegerDemo {
    static AtomicInteger i = new AtomicInteger();

    public static class AddThread implements Runnable {
        @Override
        public void run() {
            for (int k = 0; k < 10000; k++) {
                i.incrementAndGet();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] ts = new Thread[10];
        for (int k = 0; k < 10; k++) {
            ts[k] = new Thread(new AddThread());
        }
        for (int k = 0; k < 10; k++) {
            ts[k].start();
        }
        /**
         * 主线程main()等待ts[0]-ts[9]全部执行完才会执行，确保全部值执行完毕才接着执行
         * println(i)芳芳，这样才能保证值能够累加到100000
         */
        for (int k = 0; k < 10; k++) {
            ts[k].join();
        }
        System.out.println(i);
    }
}
