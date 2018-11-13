package com.dynamic.threadPic.ch17;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-11-13
 * @description 错误的加锁:Integer不变对象，一旦创建，不可修改，i++等价于i=Integer.valueOf(i.intValue()+i)
 * 所以i一直是一个变化的对象的引用，相当于两个线程对于不同的对象加了锁，所有同步就无效了
 */
public class BadLockOnInteger implements Runnable {
    public static Integer i = 0;
    static BadLockOnInteger instance = new BadLockOnInteger();

    @Override
    public void run() {
        for (int k = 0; k < 10000000; k++) {
            synchronized (i) {
                i++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }

}
