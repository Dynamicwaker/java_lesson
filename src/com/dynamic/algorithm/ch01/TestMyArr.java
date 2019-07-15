package com.dynamic.algorithm.ch01;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/9/6.20:52
 * @description
 */

public class TestMyArr {
    public static void main(String[] args) {
        MyArray myArray = new MyArray();

        myArray.insert(20);
        myArray.insert(2132);
        myArray.insert(1223);
        myArray.insert(2212);
        myArray.insert(223);

        myArray.display();

        int spot1 = myArray.find(20);
        int spot2 = myArray.find(1223);
        int spot3 = myArray.find(212);

        myArray.delete(223);
        myArray.display();

        myArray.modify(1223, 1234);
        myArray.display();
    }
}
