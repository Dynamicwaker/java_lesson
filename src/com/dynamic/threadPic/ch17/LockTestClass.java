package com.dynamic.threadPic.ch17;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-10-29
 * @description 1. 类锁：在代码中的方法上加了static和synchronized的锁，或者synchronized(xxx.class）的代码段，如下文中的increament()；
 * 2.对象锁：在代码中的方法上加了synchronized的锁，或者synchronized(this）的代码段，如下文中的synOnMethod()和synInMethod()；
 * 3.私有锁：在类内部声明一个私有属性如private Object lock，在需要加锁的代码段synchronized(lock），如下文中的synMethodWithObj()。
 * conclusion：
 * 1、类锁和对象锁不会产生竞争，二者的加锁方法不会相互影响。
 * 2、私有锁和对象锁也不会产生竞争，二者的加锁方法不会相互影响。
 * 3、synchronized直接加在方法上和synchronized(this)都是对当前对象加锁，二者的加锁方法够成了竞争关系，同一时刻只能有一个方法能执行。
 */
public class LockTestClass {
    /**
     * 用于类锁计数
     */
    private static int i = 0;
    /**
     * 私有锁
     */
    private Object object = new Object();

    /**
     * &lt;p&gt;
     * 无锁方法
     *
     * @param threadID
     * @param thread
     */
    public void noSynMethod(long threadID, ObjThread thread) {
        System.out.println("nosyn: class obj is " + thread + ", threadId is"
                + threadID);
    }

    /**
     * 对象锁方法1
     */
    public synchronized void synOnMethod() {
        System.out.println("synOnMethod begins" + ", time = "
                + System.currentTimeMillis() + "ms");
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("synOnMethod ends");
    }

    /**
     * 对象锁方法2,采用synchronized (this)来加锁
     */
    public void synInMethod() {
        synchronized (this) {
            System.out.println("synInMethod begins" + ", time = "
                    + System.currentTimeMillis() + "ms");
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("synInMethod ends");
        }

    }

    /**
     * 对象锁方法3
     */
    public void synMethodWithObj() {
        synchronized (object) {
            System.out.println("synMethodWithObj begins" + ", time = "
                    + System.currentTimeMillis() + "ms");
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("synMethodWithObj ends");
        }
    }

    /**
     * 类锁
     */
    public static synchronized void increament() {
        System.out.println("class synchronized. i = " + i + ", time = "
                + System.currentTimeMillis() + "ms");
        i++;
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("class synchronized ends.");
    }

}
