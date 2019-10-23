package com.dynamic.interview.reflect;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/9/23.20:26
 * @description 基本数据类型
 */

public class ClassDemo2 {
    public static void main(String[] args) {
        // int的类类型
        Class c1 = int.class;
        // String类的类类型，String字节码
        Class c2 = String.class;
        Class c3 = double.class;
        // c3 和 c4 不一样
        Class c4 = Double.class;
        Class c5 = void.class;
        System.out.println(c1.getName());
        System.out.println(c2.getName());
        System.out.println(c4.getName());
        System.out.println(c3.getName());
        System.out.println(c5.getName());
    }
}
