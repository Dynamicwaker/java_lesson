package com.dynamic.interview.pattern.singleton;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/11/20.23:18
 * @description 小小的问题，就是在调用STATUS时就会创建实例
 */

public class SingletonStatus {

    public static int STATUS = 1;

    private SingletonStatus() {
        System.out.println("SingletonStatus creates");
    }

    private static SingletonStatus instance = new SingletonStatus();

    public static SingletonStatus getInstance() {
        return instance;
    }
}
