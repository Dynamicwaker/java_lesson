package com.dynamic.interview;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-09-05
 * @description
 */
public class TestDemo3 {
    public static void main(String[] args) {
        // 二进制中8是一个循环
        System.out.println("=====================");
        int num = 32;
        System.out.println(num >> 32);
        System.out.println(num >> 33);
        System.out.println(num >> 34);
        System.out.println(num >> 1);
        System.out.println("=====================");
        char x = 'x';
        int i = 10;
        // 因为int i是一个整型，所以第一个输出上升为整型
        // java规范：第二个输出中有一个常量表达式，后面一个类型是T，如果T能表示常量表达式，则输出结果是T类型的
        System.out.println(false ? i : x);
        System.out.println(false ? 10 : x);

        System.out.println("=====================");
        // 由于前面一个10.9,那么运算精度会自动转化，9会变成9.0
        int a = 5;
        System.out.println("value is " + ((a < 5) ? 10.9 : 9));


    }
}
