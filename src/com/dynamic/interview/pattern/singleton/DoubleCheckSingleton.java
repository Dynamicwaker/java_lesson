package com.dynamic.interview.pattern.singleton;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2019-01-04
 * @description  双重校验锁-线程安全
 */
public class DoubleCheckSingleton {

    /**
     * 使用 volatile 可以禁止 JVM 的指令重排，保证在多线程环境下也能正常运行。
     */
    private volatile static DoubleCheckSingleton uniqueInstance;

    private DoubleCheckSingleton() {
    }

    public static DoubleCheckSingleton getUniqueInstance() {
        if (uniqueInstance == null) {
            synchronized (DoubleCheckSingleton.class) {
                /**
                 * 此处如果不做判断，可能在多线程的情况下多个线程进入，还是会生成多个实例
                 *  uniqueInstance = new Singleton(); 这段代码其实是分为三步执行：
                 *  1、为 uniqueInstance 分配内存空间
                 *  2、初始化 uniqueInstance
                 *  3、将 uniqueInstance 指向分配的内存地址
                 *  但是由于 JVM 具有指令重排的特性，执行顺序有可能变成 1>3>2。指令重排在单线程环境下不会出现问题，
                 *  但是在多线程环境下会导致一个线程获得还没有初始化的实例
                */
                if (uniqueInstance == null) {
                    uniqueInstance = new DoubleCheckSingleton();
                }
            }
        }
        return uniqueInstance;
    }
}
