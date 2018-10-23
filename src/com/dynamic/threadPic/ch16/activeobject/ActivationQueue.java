package com.dynamic.threadPic.ch16.activeobject;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-10-22
 * @description 按顺序保存MethodRequest对象的类，相当于Producer-Consumer模式中的Channel角色
 */
public class ActivationQueue {
    private static final int MAX_METHOD_REQUEST = 10;
    private final MethodRequset[] requsetQueue;

    private int tail;
    private int head;
    private int count;

    public ActivationQueue() {
        this.requsetQueue = new MethodRequset[MAX_METHOD_REQUEST];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

    public synchronized void putRequest(MethodRequset requset) {

        while (count >= requsetQueue.length) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }

        requsetQueue[tail] = requset;
        tail = (tail + 1) % requsetQueue.length;
        count++;
        notifyAll();
    }

    public synchronized MethodRequset takeRequest() {
        while (count <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        MethodRequset requset = requsetQueue[head];
        head = (head + 1) % requsetQueue.length;
        count--;
        notifyAll();
        return requset;
    }
}
