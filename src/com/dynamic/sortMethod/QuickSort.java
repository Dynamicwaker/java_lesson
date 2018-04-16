package dynamic.sortMethod;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/3/29.17:18
 * @description 快速排序
 * 工作原理：始终都是O(n log n）的时间复杂度。代价是需要额外的内存空间。
 * 该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。归并排序是一种稳定的排序方法
 * 从数列中挑出一个元素，称为 “基准”（pivot）；
 * 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
 * 在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
 * 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] testArraBefore = new int[]{9, 3, 4, 1, 6, 5, 0, 8, 7, 2};
        int[] testArrayAfter = quickSort(testArraBefore, 0, testArraBefore.length - 1);
        for (int k = 0; k < testArrayAfter.length; k++) {
            System.out.println("testArray[" + k + "]:" + testArrayAfter[k]);
        }

    }

    //递归
    public static int[] quickSort(int[] array, int start, int end) {
        if (array.length <= 1 || start < 0 || end >= array.length || start > end)
            return null;
        int smallIndex = partition(array, start, end);
        if (smallIndex > start)
            quickSort(array, start, smallIndex - 1);
        if (smallIndex < end)
            quickSort(array, smallIndex + 1, end);
        return array;
    }

    //分割,把元素比基准小的放到一边，大的放到一边，然后排序
    public static int partition(int[] array, int start, int end) {
        //double类型强转
        int pivot = (int) (start + Math.random() * (end - start + 1));
        int smallIndex = start - 1;
        swap(array, pivot, end);
        for (int i = start; i <= end; i++) {
            if (array[i] <= array[end]) {
                smallIndex++;
                if (i > smallIndex)
                    swap(array, i, smallIndex);
            }
        }
        return smallIndex;
    }

    //交换数组内两个元素
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
