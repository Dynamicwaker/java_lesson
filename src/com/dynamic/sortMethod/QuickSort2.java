package com.dynamic.sortMethod;

import java.util.Arrays;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2019/3/25.13:47
 * @description 快速排序
 */

public class QuickSort2 {

    public static void main(String[] args) {
        int[] arr = {51, 46, 20, 18, 65, 97, 82, 30, 77, 50};
        System.out.println(Arrays.toString(quickSort(arr, 0, arr.length - 1)));
    }

    public static int[] quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pivot = partition(arr, start, end);
            quickSort(arr, start, pivot - 1);
            quickSort(arr, pivot + 1, end);
        }
        return arr;
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        while (start < end) {
            while (start < end && arr[end] >= pivot)
                --end;
            arr[start] = arr[end];
            while (start < end && arr[start] <= pivot)
                ++start;
            arr[end] = arr[start];
        }
        arr[start] = pivot;
        return start;
    }
}
