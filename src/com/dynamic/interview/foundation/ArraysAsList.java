package com.dynamic.interview.foundation;

import java.util.Arrays;
import java.util.List;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/12/1.19:46
 * @description 数组和集合的转换
 */

public class ArraysAsList {
    public static void main(String[] args) {
        String[] stringArray = new String[4];
        stringArray[0] = "one";
        stringArray[1] = "two";
        stringArray[2] = "three";
        stringArray[3] = "four";

        List<String> stringList = Arrays.asList(stringArray);

        stringList.set(0, "oneList");
        // 数组的值随之改变
        System.out.println(stringArray[0]);
        /**
         * 以下三个，编译正确，但是在运行时会抛出异常，
         * Arrays.asList()适配器模式，后台仍然是数组
         * 查看源码可知Arrays.asList()的返回值ArrayList是Arrays的一个内部类，并非我们平时使用的ArrayList()
         */
        stringList.add("five");
        stringList.remove(2);
        stringList.clear();
    }
}
