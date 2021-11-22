package com.dynamic.algorithm.others.ch04;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/9/8.23:28
 * @description
 */

public class TestQueue {
    public static void main(String[] args) {
        Queue myQueue = new Queue(5);
        System.out.println(myQueue.isEmpty());

        myQueue.insert(54);
        myQueue.insert(78);
        myQueue.insert(36);
        myQueue.insert(1);
        myQueue.insert(2);

        System.out.println(myQueue.isEmpty());
        System.out.println(myQueue.isFull());

        while (!myQueue.isEmpty()) {
            System.out.println(myQueue.remove());
        }

        System.out.println("________________________________");

        // 有弊端，将全部元素remove()之后不能再进行插入操作

        MyQueue myQueueTemp = new MyQueue(5);
        System.out.println(myQueue.isEmpty());

        myQueueTemp.insert(54);
        myQueueTemp.insert(78);
        myQueueTemp.insert(36);
        myQueueTemp.insert(1);
        myQueueTemp.insert(2);

        System.out.println(myQueueTemp.isEmpty());
        System.out.println(myQueueTemp.isFull());

        while (!myQueueTemp.isEmpty()) {
            System.out.println(myQueueTemp.remove());
        }

        myQueueTemp.insert(871);

        // 优先级队列排序
        PriorityQueue pq = new PriorityQueue(10);
        pq.insert(17);
        pq.insert(9);
        pq.insert(21);
        pq.insert(2);
        pq.insert(53);

        while (!pq.isEmpty()) {
            System.out.print(pq.remove() + " ");
        }

    }
}
