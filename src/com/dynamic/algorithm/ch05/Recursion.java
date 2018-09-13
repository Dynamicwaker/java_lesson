package com.dynamic.algorithm.ch05;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/9/13.22:54
 * @description 递归, 注意调用顺序
 */

public class Recursion {
    public static void main(String[] args) {
        Recursion.test(0);
    }
    // 一个递，一个归
    public static void test(int i) {
        if (i < 100) {
            System.out.println("‘L0ve Swj!’ * " + i);
            test(++i);
            System.out.println("‘L0ve life!’ * " + i);
        }
    }

}
