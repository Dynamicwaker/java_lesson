package com.dynamic.algorithm.others.ch02;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/9/8.9:53
 * @description 冒泡排序数组
 */

public class BubbleArray {
    /**
     * 数组
     */
    private long[] arr;

    /**
     * 有效数据的大小
     */

    private int elems;

    /**
     *  默认构造方法
     */
    public BubbleArray() {
        arr = new long[50];
    }

    public BubbleArray(int max) {
        arr = new long[max];
    }

    /**
     * 插入数据
      */
    public void insert(long value) {
        arr[elems] = value;
        elems++;
    }

    /**
     * 显示数据
     */
    public void display() {
        for (int i = 0; i < elems; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * 简单冒泡
     */
    public void bubbleSort() {
        for (int i = 0; i < elems - 1; i++) {
            long temp = 0L;
            // 可知，第一遍最后一个最大的就排好了，那第二次遍历就无需比较最后一个了，以此类推
            for (int j = 0; j < elems - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

}
