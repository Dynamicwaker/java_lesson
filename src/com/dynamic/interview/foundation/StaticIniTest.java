package com.dynamic.interview.foundation;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-12-09
 * @description 类变量初始化
 * 1、定义类变量时赋值
 * 2、静态代码块里面赋值
 */
public class StaticIniTest {
    static int count = 2;

    static {
        System.out.println("StaticIniTest的静态初始化块");
        name = "java code";
    }
    /**
     * 与实例对象一致的，name先执行静态代码块里面的赋值，再执行下面的赋值，
     * 所以java code会被覆盖
    */
    static String name = "java coding";

    public static void main(String[] args) {
        System.out.println("count变量的值:" + StaticIniTest.count);
        System.out.println("name变量的值:" + StaticIniTest.name);
    }

}
