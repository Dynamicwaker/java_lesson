package com.dynamic.algorithm.others.ch02;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/9/22.23:37
 * @description 二分查找需要有序
 */

public class BinarySearch {
    public static void main(String[] args) {
        int[] arrayTemp = {1, 3, 5, 7, 8, 9, 51};
        System.out.println("值为7的数组下标为：" + rank(7, arrayTemp));

    }

    public static int rank(int key, int[] a) {
        return rank(key, a, 0, a.length - 1);
    }

    public static int rank(int key, int[] a, int min, int max) {
        if (min > max) {
            return -1;
        }
        int mid = min + (max - min) / 2;
        if (key < a[mid]) {
            return rank(key, a, min, mid - 1);
        } else if (key > a[mid]) {
            return rank(key, a, mid + 1, max);
        } else {
            return mid;
        }

    }
}


