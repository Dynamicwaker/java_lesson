package com.dynamic.interview.foundation;

import sun.swing.StringUIClientPropertyKey;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-12-09
 * @description final修饰变量初始化
 * 1、定义时赋值
 * 2、非静态代码块中赋值
 * 3、构造函数中赋值
 * 其实通过编译器处理后，都是被抽取到构造器中赋值初始值,但是final修饰的类变量的话都是放在静态初始化块内的
 * 当final修饰的变量在编译就能确定下来，则编译器会把所有的用到该变量的地方直接用该值进行替换，比如常量类的值
 */
public class FinalInstanceVaribaleTest {
    final int var1 = "java-java".length();
    final int var2;
    final int var3;

    {
        var2 = "redis-redis".length();
    }

    public FinalInstanceVaribaleTest() {
        this.var3 = "iphone-iphone".length();
    }

    public static void main(String[] args) {
        FinalInstanceVaribaleTest fiv = new FinalInstanceVaribaleTest();
        System.out.println(fiv.var1);
        System.out.println(fiv.var2);
        System.out.println(fiv.var3);
        // 字符串会缓存，因为在编译时可以确认下来，所以该变量其实也是相当于指向了缓存区的java99.0
        final String book1 = "java" + 99.0;
        // String类的方法要在运行时才知道，所以这个变量不会成为宏变量，所以并没有指向缓存中的值
        final String book2 = "java" + String.valueOf(99.0);
        System.out.println(book1 == "java99.0");
        System.out.println(book2 == "java99.0");
    }

}
