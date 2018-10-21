package com.dynamic.threadPic.ch14;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-10-21
 * @description 计数的线程
 */
public class CountupThread extends Thread {
    /**
     * 计数值
     */
    private long counter = 0;
    /**
     * 发出终止请求后变成true
     */
    private volatile boolean shutdownRequested = false;

    // 终止请求
    public void shutdownRequest() {
        shutdownRequested = true;
        // 如果该线程是sleep或者wait，光判断请求状态是不够的
        interrupt() ;
    }

    // 检查是否发出了终止请求
    public boolean isShutdownRequested() {
        return shutdownRequested;
    }

    @Override
    public void run() {
        try {
            while (!isShutdownRequested()) {
                doWork();
            }
        } catch (InterruptedException e) {

        } finally {
            doShutdown();
        }
    }

    private void doWork() throws InterruptedException {
        counter++;
        System.out.println("doWork:count = " + counter);
        Thread.sleep(500);
    }

    private void doShutdown() {
        System.out.println("doShutdow:count = " + counter);
    }
}
