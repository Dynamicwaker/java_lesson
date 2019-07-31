package com.dynamic.threadPic.ch06;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/10/13.22:36
 * @description 请求队列，存放请求信息
 * 特征：1.存在循环 2.存在条件检查 3.因为某种原因而“等待”
 */

public class RequestQueue {
    private final Queue<Request> queue = new LinkedList<Request>();

    /**
     *     会返回最先放入的请求，没有则等待，直到有线程putRequest
     */
    public synchronized Request getRequest() {
        // 如果队列中有元素则返回头元素否则返回null
        // 此处作为守护条件
        while (queue.peek() == null) {
            try {
                // 等效于this.wait()
                wait();
            } catch (InterruptedException e) {

            }
        }
        // 移除队列第一个元素，并返回该元素
        return queue.remove();
    }

    public synchronized void putRequest(Request request) {
        // 向队列的末尾添加一个请求
        queue.offer(request);
        notifyAll();
    }
}
