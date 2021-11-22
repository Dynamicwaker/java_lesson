package com.dynamic.threadPic.ch17.producer_consumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/11/24.11:35
 * @description 生产者
 */

public class Producer implements Runnable {
    private volatile boolean isRunning = true;
    /**
     * 内存缓冲区
     */
    private BlockingQueue<PCData> queue;
    /**
     * 总数，原子操作
     */
    private static AtomicInteger count = new AtomicInteger();
    private static final int SLEEP_TIME = 1000;

    public Producer(BlockingQueue<PCData> queue) {
        this.queue = queue;
    }


    @Override
    public void run() {
        PCData data;

        Random random = new Random();
        System.out.println("start producer id:" + Thread.currentThread().getId());
        try {
            while (isRunning) {
                Thread.sleep(random.nextInt(SLEEP_TIME));
                // 构造任务数据
                data = new PCData(count.incrementAndGet());
                System.out.println(data + " is put into queue");
                // 提交任务到缓冲区
                if (!queue.offer(data, 2, TimeUnit.SECONDS)) {
                    System.err.println("failed to put data:" + data);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }


    public void stop() {
        isRunning = false;
    }
}
