package com.dynamic.interview.foundation;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/11/26.22:24
 * @description 无论对于基本类型还是引用变量，java的参数传递都是值复制的传递过程
 */

public class ParmPassing {
    private static int intStatic = 222;
    private static String stringStatic = "old string";
    private static StringBuilder stringBuilderStatic = new StringBuilder("old stringBuilder");

    public static void method(int intStatic) {
        // 参数是局部变量，此处的intStatic根据作用域就近原则，只是改变了形参的值
        intStatic = 777;
    }

    public static void method() {
        // 直接修改静态变量的值
        intStatic = 888;
    }

    public static void method(String stringStatic) {
        // string是不可变对象，string没有提供任何方法修改对象
        stringStatic = "new string";
    }

    public static void method(StringBuilder stringBuilderStatic1, StringBuilder stringBuilderStatic2) {
        // 传入进来的静态变量的引用给参数列表中两个局部变量
        stringBuilderStatic1.append(".method.first-");
        stringBuilderStatic2.append("method.second-");
        // 只是新建一个对象，把这个引用指向这个对象，这个引用后续的操作与之前的静态参数没有关系
        stringBuilderStatic1 = new StringBuilder("new StringBulider");
        stringBuilderStatic1.append("new method's append");
    }

    public static void main(String[] args) {
        method(intStatic);
        method(stringStatic);
        method(stringBuilderStatic, stringBuilderStatic);
        System.out.println(intStatic);
        method();
        System.out.println(intStatic);
        System.out.println(stringStatic);
        System.out.println(stringBuilderStatic);


    }
}
