package com.dynamic.interview.pattern.singleton;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/11/20.23:20
 * @description 延迟加载的单例，只有真正需要的时候才创建，并发下加锁，对性能有影响
 */

public class LazySingleton {
    private LazySingleton() {
        System.out.println("LazySingleton creates");
    }

    private static LazySingleton instance = null;

    public static synchronized LazySingleton getInstance() {
        if (null == instance) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
