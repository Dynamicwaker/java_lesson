package com.dynamic.threadPic.ch17.producer_consumer;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/11/24.11:49
 * @description 消费者
 */

public class Consumer implements Runnable {
    private BlockingQueue<PCData> queue;
    private static final int SLEEPTIME = 1000;

    public Consumer(BlockingQueue<PCData> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("start Consumer id = " + Thread.currentThread().getId());
        Random random = new Random();

        try {
            while (true) {
                PCData pcData = queue.take();
                if (null != pcData) {
                    int result = pcData.getData() * pcData.getData();
                    System.out.println(MessageFormat.format("{0}*{1}={2}", pcData.getData(), pcData.getData(), result));
                    Thread.sleep(random.nextInt(SLEEPTIME));
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }

    }
}
