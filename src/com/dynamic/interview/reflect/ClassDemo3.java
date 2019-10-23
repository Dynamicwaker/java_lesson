package com.dynamic.interview.reflect;


/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/9/23.20:55
 * @description
 */

public class ClassDemo3 {
    public static void main(String[] args) {
        String s = "hello";
        ClassUtil.printClassMessage(s);
        System.out.println("--------------------------------------------");
        // [C类似的是数组的反射，也是最复杂的一种
        ClassUtil.printFieldMessage(s);
        System.out.println("--------------------------------------------");
        Integer i = 0;
        ClassUtil.printClassMessage(i);
        System.out.println("--------------------------------------------");
        ClassUtil.printConstructorMessage("hi");
    }
}
