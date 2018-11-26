package com.dynamic.interview.foundation;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/11/26.22:17
 * @description 父类
 */

public class Parent {
    static {
        System.out.println("Parent 静态代码块");
    }

    public Parent() {
        System.out.println("Parent 构造方法");
    }
}
