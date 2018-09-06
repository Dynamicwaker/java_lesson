package com.dynamic.sortMethod;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @description 冒泡排序，工作原理：
 * 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
 * 针对所有的元素重复以上的步骤，除了最后一个；
 * 重复步骤1~3，直到排序完成。
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] testArray = bubbleSort(new int[]{9, 3, 4, 1, 6, 5, 7, 0, 8, 7, 2});
        for (int k = 0; k < testArray.length; k++) {
            System.out.println("testArray[" + k + "]:" + testArray[k]);
        }

    }

    public static int[] bubbleSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        // 针对所有的元素重复以上的步骤，除了最后一个；
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++)
                if (array[j + 1] < array[j]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
        }
        return array;
    }

}
