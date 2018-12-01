package com.dynamic.interview.foundation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/12/1.19:57
 * @description 集合转成数组
 */

public class ListToArray {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        // 泛型丢失，无法使用String[]接收无参方法返回的结果
        Object[] array1 = list.toArray();

        // array2数组长度小于元素个数,输出结果都是null，数组长度不够，不够就启用该数组
        String[] array2 = new String[2];
        list.toArray(array2);
        System.out.println(Arrays.asList(array2));

        // array3数组长度等于元素个数，这个可以将集合元素转换过来，数组长度和list长度一致时也是效率最高的时候
        String[] array3 = new String[3];
        list.toArray(array3);
        System.out.println(Arrays.asList(array3));
    }
}
