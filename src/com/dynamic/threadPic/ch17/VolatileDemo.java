package com.dynamic.threadPic.ch17;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/10/30.23:19
 * @description
 * synchronized关键字、Lock对象同时支持原子性、有序性和可见性
 * volatile关键字只支持可见性和有序性，并不保证原子性。
 * 使用了volatile关键字，因此自定义线程每次修改时状态变量的值时，主线程都可以实时的感知到。
 * 对于多个线程都依赖于同一个状态变量的值来判断是否要执行某段代码时，使用volatile关键字更为有用，其可以保证多个线程在任一时刻的行为都是一致的
 */

public class VolatileDemo {

    volatile static Boolean flag = true;

    public static void main(String[] args) {
        // 该线程每隔1毫秒，修改一次flag的值
        new Thread() {
            @Override
            public void run() {
                try {
                    this.sleep(1000000);
                    flag = !flag;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        // 主线程通过死循环不断根据flag进行判断是否要执行某段代码
        while (true) {
            if (flag) {
                System.out.println("do some thing...");
            } else {
                System.out.println("...");
            }
        }


    }
}
