package com.dynamic.threadPic.ch17;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/10/28.14:33
 * @description 创建线程的时候，如果没有指定优先级，默认是5。主线程的优先级也是5。
 * 优先级高的线程可能会比优先级低的线程获得更多的运行机会，注意是可能
 */

public class PriorityDemo {
    public static void main(String[] args) {
        System.out.println("最大优先级;" + Thread.MAX_PRIORITY);
        System.out.println("正常优先级;" + Thread.NORM_PRIORITY);
        System.out.println("最小优先级;" + Thread.MIN_PRIORITY);
        System.out.println("主线程优先级;" + Thread.currentThread().getPriority());
        Thread t = new Thread();
        System.out.println("创建一个线程默认的优先级:" + t.getPriority());
    }
}
