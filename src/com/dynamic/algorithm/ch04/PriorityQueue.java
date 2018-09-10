package com.dynamic.algorithm.ch04;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/9/10.21:15
 * @description 优先级队列的简单实现, 插入的时候按照一定顺序插入相对顺序的位置
 */

public class PriorityQueue {
    // 数组
    private int[] arr;
    // 最大空间
    private int maxSize;
    // 有效元素大小
    private int elems;

    public PriorityQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        elems = 0;
    }

    // 插入数据
    public void insert(int value) {
        int i;
        // 大于数据的话，将之后的数据向后移动一位,从小到大排序
        for (i = 0; i < elems; i++) {
            if (arr[i] < value) {
                break;
            }
        }
        for (int j = elems; j > i; j--) {
            arr[j] = arr[j - 1];
        }
        arr[i] = value;
        elems++;

    }

    // 移除数据,没有头指针了
    public long remove() {
        long value = arr[elems - 1];
        elems--;
        return value;
    }

    // 是否为空
    public boolean isEmpty() {
        return (elems == 0);
    }

    // 是否满了
    public boolean isFull() {
        return (elems == maxSize);
    }

    public int size() {
        return elems;
    }

}
