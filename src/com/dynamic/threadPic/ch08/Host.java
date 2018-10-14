package com.dynamic.threadPic.ch08;

import java.util.concurrent.TimeoutException;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-10-14
 * @description
 */
public class Host {
    /**
     * 超时时间
     */
    private final long timeout;
    /**
     * 方法正常执行时值为true
     */
    private boolean ready = false;

    public Host(long timeout) {
        this.timeout = timeout;
    }

    // 修改状态
    public synchronized void setExecutable(boolean on) {
        ready = on;
        notifyAll();
    }

    public synchronized void execute() throws InterruptedException, TimeoutException {
        long start = System.currentTimeMillis();
        while (!ready) {
            long now = System.currentTimeMillis();
            long rest = timeout - (now - start);
            if (rest <= 0) {
                throw new TimeoutException("now - start = " + (now - start) + ", timeout = " + timeout);
            }
            wait(rest);
        }
        doExecute();

    }

    private void doExecute() {
        System.out.println(Thread.currentThread().getName() + " calls doExecute");
    }

}
