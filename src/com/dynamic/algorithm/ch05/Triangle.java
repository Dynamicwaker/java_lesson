package com.dynamic.algorithm.ch05;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/9/13.23:10
 * @description 使用递归
 */

public class Triangle {
    public static void main(String[] args) {
        System.out.println(triangleTest(1));
        System.out.println(triangleTest(2));
        System.out.println(triangleTest(3));
        System.out.println(triangleTest(4));
        System.out.println("-----------------------------");
        System.out.println(triangleRecursion(1));
        System.out.println(triangleRecursion(2));
        System.out.println(triangleRecursion(3));
        System.out.println(triangleRecursion(4));
    }

    // 使用循环
    public static int triangleTest(int n) {
        int total = 0;
        while (n > 0) {
            total = total + n;
            n--;
        }
        return total;
    }

    // 使用递归
    public static int triangleRecursion(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + triangleRecursion(--n);
        }
    }
}
