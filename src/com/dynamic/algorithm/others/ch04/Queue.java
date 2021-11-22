package com.dynamic.algorithm.others.ch04;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/9/8.23:19
 * @description 实现简单队列
 */

public class Queue {
    /**
     * 数组
     */
    private int[] arr;
    /**
     * 最大空间
     */
    private int maxSize;
    /**
     * 有效元素大小
     */
    private int elems;
    /**
     * 队头
     */
    private int font;
    /**
     * 队尾
     */
    private int end;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        elems = 0;
        font = 0;
        end = -1;
    }

    /**
     * 插入数据
     */
    public void insert(int value) {
        arr[++end] = value;
        elems++;
    }

    /**
     * 移除数据
     */
    public long remove() {
        elems--;
        return arr[font++];
    }

    /**
     * 是否为空
     */
    public boolean isEmpty() {
        return (elems == 0);
    }

    /**
     * 是否满了
     */
    public boolean isFull() {
        return (end == maxSize - 1);
    }

    public int size() {
        return elems;
    }


}
