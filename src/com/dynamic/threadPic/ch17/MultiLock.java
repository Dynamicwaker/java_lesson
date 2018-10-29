package com.dynamic.threadPic.ch17;

import java.util.ArrayList;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-10-29
 * @description 只有在使用同一个锁的情况下，才能保证任意时刻，只能有一个线程对变量进行修改。
 */
public class MultiLock {
    static int count = 0;
    /**
     * 定义两个锁，前面我们已经提到，任何的Java对象实例都可以当成锁，这里用两个不同的字符串实例表示两个不同的锁
     */

    static String lock1 = "lock1";
    static String lock2 = "lock2";

    public static void main(String[] args) throws InterruptedException {
        final long start = System.currentTimeMillis();
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 5000000; i++) {
                    // 使用lock1
                    synchronized (lock1) {
                        count++;
                    }
                }
                System.out.println("自定义线程:计算完成...，耗时" + (System.currentTimeMillis() - start));
            }
        }.start();
        for (int i = 0; i < 5000000; i++) {
            // 使用lock2
            synchronized (lock2) {
                count++;
            }
        }
        System.out.println("主线程:计算完成....，耗时" + (System.currentTimeMillis() - start));
        Thread.sleep(10000);
        System.out.println("count:" + count);
    }
}
