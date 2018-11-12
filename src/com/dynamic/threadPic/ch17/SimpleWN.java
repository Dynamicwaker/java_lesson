package com.dynamic.threadPic.ch17;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/11/12.22:40
 * @description 简单的wait()和notify()
 * wait() 和 Thread.sleep()主要区别：wait()会释放目标对象的锁，sleep()不会,wait()还可以被唤醒
 */

public class SimpleWN {

    final static Object object = new Object();

    public static class T1 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + ":T1 start");
                try {
                    System.out.println(System.currentTimeMillis() + ":T1 wait for object ");
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + ":T1 end!");
            }
        }
    }

    public static class T2 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + ":T2 start!notify one thread");
                object.notify();
                System.out.println(System.currentTimeMillis() + ":T2 end!");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {

                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new T1();
        Thread t2 = new T2();
        t1.start();
        t2.start();
    }
}
