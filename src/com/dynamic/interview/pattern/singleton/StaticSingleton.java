package com.dynamic.interview.pattern.singleton;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/11/20.23:23
 * @description 比较完美的方式：静态内部类实现
 * 当 Singleton 类加载时，静态内部类 SingletonHolder 没有被加载进内存。
 * 只有当调用 getUniqueInstance() 方法从而触发 SingletonHolder.INSTANCE 时 SingletonHolder 才会被加载，
 * 此时初始化 INSTANCE 实例，并且 JVM 能确保 INSTANCE 只被实例化一次。
 *
 * 序列化和反序列化可能会破坏单例
 */

public class StaticSingleton {

    private StaticSingleton() {
        System.out.println("StaticSingleton creates");
    }

    private static class SingletonHolder {
        private static StaticSingleton INSTANCE = new StaticSingleton();
    }

    public static StaticSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
