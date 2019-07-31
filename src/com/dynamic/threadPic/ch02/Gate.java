package com.dynamic.threadPic.ch02;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/10/1.22:53
 * @description 门 如果pass和toString方法是非线程安全的，实例被多个线程使用的时候，运行结果会和预期不一致
 * 门在这个例子是作为共享资源，可以被多个线程访问
 * java的集合类中大多是非线程安全的，在api中都有标记
 */

public class Gate {
    private int counter = 0;
    private String name = "Nobody";
    private String address = "NoWhere";

    /**
     * 改写成synchronized
     */
    public synchronized void pass(String name, String address) {
        this.counter++;
        this.name = name;
        this.address = address;
        check();
    }

    /**
     * 改写成synchronized
     */
    @Override
    public synchronized String toString() {
        return "No." + counter + ": " + name + ", " + address;

    }

    private void check() {
        if (name.charAt(0) != address.charAt(0)) {
            System.out.println("***BROKEN*** " + toString());
        }
    }
}
