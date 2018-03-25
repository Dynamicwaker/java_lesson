package dynamic.sortMethod;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @description 选择排序，最稳定的排序算法之一，工作原理：
 * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
 * 然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
 */
public class SelSort {
    public static void main(String[] args){
        int[] testArray = selectionSort(new int[]{9,3,4,1,6,5,0,8,7,2});
        for(int k=0; k<testArray.length;k++){
            System.out.println("testArray[" + k + "]:" + testArray[k]);
        }
    }

    public static int[] selectionSort(int[] array){
        if(array.length==0)
            return array;

        for(int i = 0;i<array.length;i++){
            int minIndex = i;
            for(int j = i;j<array.length;j++) {
                if (array[j] < array[minIndex])//找到最小的数
                    minIndex = j;//保存最小数的索引
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }
}
