package com.dynamic.algorithm.ch02;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/9/8.10:10
 * @description 选择排序数组
 */

public class SelArray {

    // 数组
    private long[] arr;

    // 有效数据的大小
    private int elems;

    //默认构造方法
    public SelArray() {
        arr = new long[50];
    }

    public SelArray(int max) {
        arr = new long[max];
    }

    // 插入数据
    public void insert(long value) {
        arr[elems] = value;
        elems++;
    }

    // 显示数据
    public void display() {
        for (int i = 0; i < elems; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // 选择排序
    public void selSort() {
        // 经过n-1次操作后，最后一个操作不用执行最后也是最大的了
        long temp = 0L;
        int min = 0;
        for (int i = 0; i < elems - 1; i++) {
            min = i;
            for (int j = i; j < elems; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

}
