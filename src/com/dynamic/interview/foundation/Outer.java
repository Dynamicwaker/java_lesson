package com.dynamic.interview.foundation;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/12/4.23:04
 * @description 下面的代码哪些地方会产生编译错误？foo和main方法都是静态方法，静态方法中没有this，也就是说没有所谓的外部类对象，因此无法创建内部类对象，
 * 如果要在静态方法中创建内部类对象,可以使用 new Outer().new Inner();
 */

public class Outer {
    class Inner {
    }

    public static void foo() {

        // new Inner();
    }

    public void bar() {
        new Inner();
    }

    public static void main(String[] args) {
        // new Inner();
        new Outer().new Inner();
    }
}
