package dynamic.sortMethod;

import java.util.Arrays;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/3/25.23:33
 * @description 归并排序
 * 工作原理：始终都是O(n log n）的时间复杂度。代价是需要额外的内存空间。
 * 该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。归并排序是一种稳定的排序方法
 */

public class MergeSort {

    public static void main(String[] args) {
        int[] testArray = mergeSort(new int[]{9, 3, 4, 1, 6, 5, 0, 8, 7, 2});
        for (int k = 0; k < testArray.length; k++) {
            System.out.println("testArray[" + k + "]:" + testArray[k]);
        }

    }

    public static int[] mergeSort(int[] array) {
        if (array.length < 2)
            return array;
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(mergeSort(left), mergeSort(right));
    }


    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length)
                result[index] = right[j++];
            else if (j >= right.length)
                result[index] = left[i++];
            else if (left[i] > right[j])
                result[index] = right[j++];
            else
                result[index] = left[i++];
        }
        return result;

    }

}
