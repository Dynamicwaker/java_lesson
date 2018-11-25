package com.dynamic.interview.others;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/11/25.10:26
 * @description 冒泡排序优化
 */

public class BubbleSSort {
    public static void bubbleSort(int[] source) {
        boolean exchange;
        for (int i = source.length - 1; i > 0; i--) {
            exchange = false;
            for (int j = 0; j < i; j++) {
                if (source[j] > source[j + 1]) {
                    swap(source, j, j + 1);
                    exchange = true;
                }
            }
            // 如果没有发生位置置换，则说明待排序区的数据已经有序，则返回，不再进行处理
            if (!exchange) {
                return;
            }
        }
    }

    public static void swap(int[] array, int j, int k) {
        int temp = array[j];
        array[j] = array[k];
        array[k] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9, 2, 1, 4, 3, 8, 0};
        bubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print("arr[" + i + "]=" + arr[i] + " ");
        }
    }
}
