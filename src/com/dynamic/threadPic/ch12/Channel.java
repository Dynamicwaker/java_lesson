package com.dynamic.threadPic.ch12;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/10/16.21:19
 * @description 负责传递工作请求和我保存工人线程的类
 */

public class Channel {
    private static final int MAX_REQUEST = 100;
    private final Request[] requestQueue;
    /**
     * 下次putRequest的位置
     */
    private int tail;
    /**
     * 下次takeRequest的位置
     */
    private int head;
    /**
     * Request的数量
     */
    private int count;

    private final WorkThread[] threadPool;

    public Channel(int threads) {
        this.requestQueue = new Request[MAX_REQUEST];
        this.count = 0;
        this.tail = 0;
        this.head = 0;
        threadPool = new WorkThread[threads];
        for (int i = 0; i < threadPool.length; i++) {
            threadPool[i] = new WorkThread("Worker-" + i, this);
        }
    }

    public void startWorkers() {
        for (int i = 0; i < threadPool.length; i++) {
            threadPool[i].start();
        }
    }

    public synchronized void putRequest(Request request) {
        while (count >= requestQueue.length) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        requestQueue[tail] = request;
        tail = (tail + 1) % requestQueue.length;
        count++;
        notifyAll();
    }

    public synchronized Request takeRequest() {
        while (count <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        Request request = requestQueue[head];
        head = (head + 1) % requestQueue.length;
        count--;
        notifyAll();
        return request;
    }
}
