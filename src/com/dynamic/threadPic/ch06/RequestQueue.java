package com.dynamic.threadPic.ch06;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/10/13.22:36
 * @description 请求队列，存放请求信息
 */

public class RequestQueue {
    private final Queue<Request> queue = new LinkedList<Request>();

    // 会返回最先放入的请求，没有则等待，直到有线程putRequest
    public synchronized Request getRequest() {
        // 如果队列中有元素则返回头元素否则返回null
        while (queue.peek() == null) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        // 移除队列第一个元素，并返回该元素
        return queue.remove();
    }

    public synchronized void putRequest(Request request) {
        queue.offer(request);
        notifyAll();
    }
}
