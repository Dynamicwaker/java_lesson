package com.dynamic.threadPic.ch17;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-11-16
 * @description CountDownLatch倒计时器，模拟火箭发射
 */
public class CountDownLatchDemo implements Runnable {
    /**
     * 等待10个线程执行完主线程才能执行
    */
    static final CountDownLatch end = new CountDownLatch(10);
    static final CountDownLatchDemo demo = new CountDownLatchDemo();

    @Override
    public void run() {
        try {
            // 模拟检查任务
            Thread.sleep(new Random().nextInt(10) * 1000);
            System.out.println("check complete!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 计数器减1
            end.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 分配10个线程
        ExecutorService exec = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            exec.submit(demo);
        }

        end.await();
        System.out.println("Fire!");
        exec.shutdown();
    }
}
