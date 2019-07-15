package com.dynamic.interview;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-09-04
 * @description i++和++i问题
 */
public class TestDemo {
    static {
        // 在第一次被载入jvm时运行，但由于是局部变量，x=5不影响后面的值
        int x = 5;
    }
    /**
     * 初始化时x = y = 0
     */
    static int x, y;

    public static void main(String[] args) {
        x--;
        System.out.println("1: x=" + x);
        mymethod();
        System.out.println("2: x=" + x);
        System.out.println(x + y++ + x);

        int a = 5;
        int b = 3;
        if (!(a == b) && (a == 1 + b++)) {
        }
        ;
        // !(a==b)为真，不短路，后面的表达式还要执行
        System.out.println("a = " + a);
        System.out.println("b = " + b);

    }

    public static void mymethod() {
        // x先++等于0在运算再进行后++，执行完x=1，y=0+0=0
        y = x++ + ++x;
    }
}
