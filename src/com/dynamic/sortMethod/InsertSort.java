package com.dynamic.sortMethod;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/3/25.21:27
 * @description 插入排序，工作原理：
 * 从第一个元素开始，该元素可以认为已经被排序；
 * 取出下一个元素，在已经排序的元素序列中从后向前扫描；
 * 如果该元素（已排序）大于新元素，将该元素移到下一位置；
 * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
 * 将新元素插入到该位置后；
 * 重复步骤2~5。
 */

public class InsertSort {
    public static void main(String[] args) {
        int[] testArray = insertionSort(new int[]{9, 3, 4, 1, 6, 5, 7, 0, 8, 7, 2});
        for (int k = 0; k < testArray.length; k++) {
            System.out.println("testArray[" + k + "]:" + testArray[k]);
        }
    }

    public static int[] insertionSort(int[] array) {
        if (array.length == 0)
            return array;
        // 第一个元素被认为已排序
        int current;//不要在循环中定义变量
        for (int i = 1; i < array.length - 1; i++) {
            current = array[i];
            int preIndex = i - 1;
            // 循环与之前的位置进行比较，如果大了就往后挪
            while (preIndex >= 0 && current < array[preIndex]) {
                // 把之前有序的依次往后挪1，把大的值放到后面
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            // 把现在的值插入刚才有序的位置，preindex之前--，所以这里加1
            array[preIndex + 1] = current;
        }
        return array;

    }
}
