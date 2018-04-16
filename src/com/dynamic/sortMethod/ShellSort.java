package dynamic.sortMethod;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/3/25.22:05
 * @description 希尔排序，希尔排序也是一种插入排序，它是简单插入排序经过改进之后的一个更高效的版本，也称为缩小增量排序，同时该算法是冲破O(n2）的第一批算法之一
 * 工作原理：先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，具体算法描述：
 * 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
 * 按增量序列个数k，对序列进行k 趟排序；
 * 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。
 * 仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 */

public class ShellSort {
    public static void main(String[] args) {
        int[] testArray = shellSort(new int[]{9, 3, 4, 1, 6, 5, 0, 8, 7, 2});
        for (int k = 0; k < testArray.length; k++) {
            System.out.println("testArray[" + k + "]:" + testArray[k]);
        }
    }

    public static int[] shellSort(int[] array) {
        int len = array.length;
        //gap为初始增量，就是把array分为几组，隔多少距离的元素进行比较
        int temp, gap = len / 2;
        if (len == 0)
            return array;
        while (gap > 0) {
//            与插入排序类似，但是分组进行比较
            for (int i = gap; i < len; i++) {
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return array;
    }
}
