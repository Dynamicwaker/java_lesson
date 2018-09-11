package com.dynamic.algorithm.ch04;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/9/8.23:19
 * @description 实现简单循环队列
 */

public class MyQueue {
    // 数组
    private int[] arr;
    // 最大空间
    private int maxSize;
    // 有效元素大小
    private int elems;
    // 队头
    private int font;
    // 队尾
    private int end;

    public MyQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        elems = 0;
        font = 0;
        end = -1;
    }

    // 插入数据
    public void insert(int value) {
        // 队列已满最将队尾指针指向最初
        if (end == maxSize - 1) {
            end = -1;
        }
        arr[++end] = value;
        elems++;
    }

    // 移除数据
    public long remove() {
        // 删除之前先拿到temp的值，再变更指针
        int tmep = arr[font++];
        if (font == maxSize) {
            font = 0;
        }
        elems--;
        return tmep;
    }

    // 是否为空
    public boolean isEmpty() {
        return (elems == 0);
    }

    // 是否满了
    public boolean isFull() {
        return (end == maxSize - 1);
    }

    // 获取大小
    public int size() {
        return elems;
    }


}
