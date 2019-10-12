package com.dynamic.algorithm.others.ch01;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/9/6.20:52
 * @description
 */

public class TestMyOrderedArr {
    public static void main(String[] args) {
        MyOrderedArray myArray = new MyOrderedArray();

        myArray.insert(21);
        myArray.insert(99);
        myArray.insert(45);
        myArray.insert(71);
        myArray.insert(36);

        myArray.display();
        System.out.println(myArray.binarySearch(45));
        System.out.println(myArray.binarySearch(99));
        System.out.println(myArray.binarySearch(21));
    }
}
