package com.dynamic.threadPic.ch17;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/11/14.23:54
 * @description 多线程信号量demo
 */

public class Semap implements Runnable {
    final Semaphore semaphore = new Semaphore(5);

    @Override
    public void run() {
        try {
            // 可以同时有5个线程进入临界区，5个一组为单位，依次输出带有线程id的提示文本
            semaphore.acquire();
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getId() + ":done!");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        final Semap semap = new Semap();
        for (int i =0;i<20;i++){
            executorService.submit(semap);
        }

    }
}
