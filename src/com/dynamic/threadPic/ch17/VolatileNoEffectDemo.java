package com.dynamic.threadPic.ch17;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-11-13
 * @description volatile不能代替锁，不能保证操作的原子性
 */
public class VolatileNoEffectDemo {
    public static volatile int i = 0;

    public static class PlusTask implements Runnable {
        @Override
        public void run() {
            for (int k = 0; k < 10000; k++) {
                i++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new PlusTask());
            threads[i].start();
        }

        for (int j = 0; j < 10; j++) {
            threads[j].join();
        }
        // 如何i++是原子性，10个线程每个累加10000，最终的一定是100000，但是实际会比其小，是因为volatile不能保证原子性
        System.out.println(i);
    }
}
