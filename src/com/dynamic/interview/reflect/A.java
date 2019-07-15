package com.dynamic.interview.reflect;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/9/23.22:43
 * @description
 */

public class A {
    public void print(int a, int b) {
        System.out.println(a + b);
    }

    public void print(String a, String b) {
        System.out.println(a.toUpperCase() + "," + b.toUpperCase());
    }

    public void print() {
        System.out.println("test void case!");
    }


}
