package com.dynamic.threadPic.ch17;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-11-19
 * @description ThreadLocal性能测试:是否需要使用ThreadLocal为每个线程分配一个独立的对象
 */
public class ThreadLocalPerformanceDemo {
    public static final int GEN_COUNT = 10000000;
    public static final int THREAD_COUNT = 4;

    static ExecutorService exe = Executors.newFixedThreadPool(THREAD_COUNT);
    public static Random rnd = new Random(123);

    public static ThreadLocal<Random> tRnd = new ThreadLocal<Random>() {
        @Override
        protected Random initialValue() {
            return new Random(123);
        }
    };

    public static class RndTask implements Callable<Long> {
        private int mode = 0;

        public RndTask(int mode) {
            this.mode = mode;
        }

        public Random getRandom() {
            if (mode == 0) {
                return rnd;
            } else if (mode == 1) {
                return tRnd.get();
            } else {
                return null;
            }
        }

        @Override
        public Long call() {
            long b = System.currentTimeMillis();
            for (long i = 0; i < GEN_COUNT; i++) {
                getRandom().nextInt();
            }
            long e = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + " spends " + (e - b) + "ms");
            return e - b;
        }

    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Future<Long>[] futs = new Future[THREAD_COUNT];
        for (int j = 0; j < THREAD_COUNT; j++) {
            futs[j] = exe.submit(new RndTask(0));
        }
        long totalTime = 0;
        for (int i = 0; i < THREAD_COUNT; i++) {
            totalTime += futs[i].get();
        }
        System.out.println("多线程访问同一个Random实例：" + totalTime + "ms");
        // ThreadLocal的情况
        for (int j = 0; j < THREAD_COUNT; j++) {
            futs[j] = exe.submit(new RndTask(1));
        }
        totalTime = 0;
        for (int i = 0; i < THREAD_COUNT; i++) {
            totalTime += futs[i].get();
        }
        System.out.println("使用ThreadLocal包装Random实例：" + totalTime + "ms");
        exe.shutdown();
    }

}
