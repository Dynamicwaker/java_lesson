package com.dynamic.sortMethed;
/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @description 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] testArray = bubbleSort(new int[]{9,3,4,1,6,5,7,0,8,7,2});
        for(int k=0; k<testArray.length;k++){
            System.out.println("testArray[" + k + "]:" + testArray[k]);
        }

    }

    public static int[] bubbleSort(int[] array){
        if(array.length == 0){
            return array;
        }
        for(int i = 0; i < array.length; i++){
            for(int j = 0;j < array.length -1- i; j ++)
                if(array[j+1]<array[j]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                 }
        }
        return array;
    }

}
