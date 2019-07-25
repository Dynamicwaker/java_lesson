package com.dynamic.interview.others;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/9/18.22:55
 * @description 常用String测试
 */

public class TestDemo4 {
    public static void main(String[] args) {
        // a 为一个引用
        String a = new String("ab");
        // b为另一个引用,对象的内容一样
        String b = new String("ab");
        // 放在常量池中
        String aa = "ab";
        // 从常量池中查找
        String bb = "ab";
        // true
        if (aa == bb) {
            System.out.println("aa == bb");
        }
        // false，非同一对象
        if (a == b) {
            System.out.println("a == b");
        }
        // true
        if (a.equals(b)) {
            System.out.println("aEQb");
        }
        // true
        if (42 == 42.0) {
            System.out.println("true");
        }
        System.out.println("-------------------基本类型和包装类型-------------------------");
        // 类似的
        Integer aaa = new Integer(3);
        Integer bbb = 3;
        int ccc = 3;
        System.out.println("aaa == bbb: " + (aaa == bbb));
        System.out.println("bbb == ccc: " + (bbb == ccc));
        System.out.println("--------------------------易错点-----------------------------");
        // 如果整型字面量的值在-128到127之间，那么不会new新的Integer对象，而是直接引用常量池中的Integer对象，
        // 所以上面的面试题中f1==f2的结果是true，而f3==f4的结果是false。
        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
        System.out.println("f1 == f2: " + (f1 == f2));
        System.out.println("f3 == f4: " + (f3 == f4));
        System.out.println("--------------------------易错点-----------------------------");
        //这段代码在jdk1.6中运行，会得到两个false，而在jdk1.7中运行会得到一个true一个false。
        // 产生差异的原因是：在jdk1.6中，intern()方法会把首次遇到的字符串实例复制到永久代中，返回的也是永久代中这个字符串实例的引用，
        // 而用StringBuilder创建的字符串实例在Java堆上，所以必然不是同一个引用，将返回false。
        // 而jdk1.7中的intern()实现不会再复制实例，只是在常量池中记录首次出现的实例引用，因此intern()返回的引用和由StringBuilder创建的那个字符串实例是同一个。
        // 对str2比较返回false是因为“java”这个字符串在执行StringBuilder.toString()之前已经出现过，
        // 字符串常量池中已经有它的引用了，不符合首次出现的原则，
        String s1 = new StringBuilder("go").append("od").toString();
        System.out.println(s1.intern() == s1);
        String s2 = new StringBuilder("ja").append("va").toString();
        System.out.println(s2.intern() == s2);
        // 最高效的实现计算2乘以8
        int result = 2 << 3;
        System.out.println("result: " + result);
        // Java语言的方法调用只支持参数的值传递，当一个对象实例作为一个参数被传递到方法中时，参数的值就是对该对象的引用。
        // 对象的属性可以在被调用过程中被改变，但对对象引用的改变是不会影响到调用者的
    }
}
