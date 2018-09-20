package com.dynamic.interview;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-09-20
 * @description String.StringBuilder, StringBuffer区别
 */
public class ThreeDiffer {
    // Java平台提供了两种类型的字符串：String和StringBuffer/StringBuilder，它们可以储存和操作字符串
    // 其中String是只读字符串，也就意味着String引用的字符串内容是不能被改变的。
    // 而StringBuffer/StringBuilder类表示的字符串对象可以直接进行修改。
    // StringBuilder是Java 5中引入的，它和StringBuffer的方法完全相同，
    // 区别在于它是在单线程环境下使用的，因为它的所有方面都没有被synchronized修饰，因此它的效率也比StringBuffer要高,但是它是线程不安全。
    public static void main(String[] args) {
        // intern 常量池里面有就返回它的引用，
        // intern方法会得到字符串对象在常量池中对应的版本的引用（如果常量池中有一个字符串与String对象的equals结果是true）
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        String s6 = s3 + s4;
        System.out.println(s1 == s2);
        System.out.println(s1 == s5);
        System.out.println(s1 == s6);
        System.out.println(s1 == s6.intern());
        System.out.println(s2 == s2.intern());
    }
}
