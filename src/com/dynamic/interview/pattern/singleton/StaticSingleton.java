package com.dynamic.interview.pattern.singleton;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/11/20.23:23
 * @description 比较完美的方式
 */

public class StaticSingleton {

    private StaticSingleton() {
        System.out.println("StaticSingleton creates");
    }

    private static class SingletonHolder {
        private static StaticSingleton instance = new StaticSingleton();
    }

    public static StaticSingleton getInstance() {
        return SingletonHolder.instance;
    }
}
