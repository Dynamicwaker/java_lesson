package com.dynamic.threadPic.ch03;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-10-10
 * @description 资源个数有限
 */
public class BoundedResource {
    private final Semaphore semaphore;
    private final int permits;
    private final static Random random = new Random(314159);

    public BoundedResource(int permits) {
        // 设置资源限制
        this.semaphore = new Semaphore(permits);
        this.permits = permits;
    }

    public void use() throws InterruptedException {
        // 用于确保存在可用资源，存在，线程立即使用，资源个数减1
        semaphore.acquire();
        try {
            doUse();
        } finally {
            // 释放资源，资源个数加1
            semaphore.release();
        }
    }

    /**
     * 实际使用资源，permits - semaphore.availablePermits() 表示当前正在使用中的资源个数
     */
    protected void doUse() throws InterruptedException {
        Log.println("BEGIN: used = " + (permits - semaphore.availablePermits()));
        Thread.sleep(random.nextInt(500));
        Log.println("END: used = " + (permits - semaphore.availablePermits()));
    }
}
