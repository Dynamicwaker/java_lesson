package com.dynamic.threadPic.ch16.activeobject;

import com.dynamic.interview.reflect.A;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-10-22
 * @description 调用execute方法处理MethodRequest的类
 */
public class SchedulerThread extends Thread {
    private final ActivationQueue queue;

    public SchedulerThread(ActivationQueue queue) {
        this.queue = queue;
    }

    /**
     * invoke()和execute()是两个不同的线程
    */
    public void invoke(MethodRequset requset) {
        queue.putRequest(requset);
    }

    @Override
    public void run() {
        while (true) {
            MethodRequset requset = queue.takeRequest();
            requset.execute();
        }
    }
}
