package com.dynamic.interview.foundation;

import java.util.HashSet;
import java.util.Set;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-12-09
 * @description HashSet判断两个对象是否相等除了判断值相等之外，还要判断对象的hashcode返回值是否相等
 * 因为示例程序中没有重写hashcode方法，两个对象的hashcode返回值不一致，所以不相等
 */
public class HashSetTest {
    public static void main(String[] args) {
        Set<Name> nameSet = new HashSet<>();
        nameSet.add(new Name("hello", "kitty"));
        System.out.println(nameSet.contains(new Name("hello", "kitty")));
    }
}
