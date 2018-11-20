package com.dynamic.interview.pattern.singleton;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/11/20.23:15
 * @description 最简单的单例模式
 */

public class Singleton {
    private Singleton() {
        System.out.println("Singleton creates");
    }

    private static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }
}
