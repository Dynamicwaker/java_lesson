package com.dynamic.threadPic.ch17;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-11-01
 * @description Unsafe做操作的是直接内存区，所以该类没有办法通过HotSpot的GC进行回收，需要进行手动回收，
 * 因此在使用此类时需要注意内存泄漏（Memory Leak）和内存溢出（Out Of Memory）。
 * Unsafe类提供了一个静态方法getUnsafe()来获取Unsafe的实例，
 * 但是如果你尝试调用Unsafe.getUnsafe()，会得到一个SecutiryException。这个类只有被JDK信任的类实例化。
 */
public class UnsafeDemo {
    private int i = 0;

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        // 使用反射获取Unsafe实例
        // Internal reference
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);

        // 获取字段i在内存中偏移量
        long offset = unsafe.objectFieldOffset(UnsafeDemo.class.getDeclaredField("i"));

        // 创建对象实例，设置字段的值
        UnsafeDemo unsafeDemo = new UnsafeDemo();
        unsafe.putInt(unsafeDemo, offset, 100);

        // 打印结果
        System.out.println(unsafeDemo.i);

        // This creates an instance of player class without any initialization
        // 通过allocateInstance()方法，你可以创建一个类的实例，
        // 但是却不需要调用它的构造函数、初使化代码、各种JVM安全检查以及其它的一些底层的东西。
        // 即使构造函数是私有，我们也可以通过这个方法创建它的实例。
        Player p = (Player) unsafe.allocateInstance(Player.class);
        // Print 0
        System.out.println(p.getAge());
        // Let's now set age 45 to un-initialized object
        p.setAge(45);
        // Print 45
        System.out.println(p.getAge());
    }
}
