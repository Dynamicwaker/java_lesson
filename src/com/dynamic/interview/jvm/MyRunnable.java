package com.dynamic.interview.jvm;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-10-24
 * @description 假设有两个线程执行run，执行methodOne
 * methodOne()声明了一个原始类型的本地变量和一个引用类型的本地变量。
 * 每个线程执行methodOne()都会在它们对应的线程栈上创建localVariable1和localVariable2的私有拷贝。
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        methodOne();
    }

    public void methodOne() {
        /**
         * 在对应线程的线程栈上
         */
        int localVariable1 = 45;
        /**
         * MySharedObject实例存放在堆上，localVariable2引用在对应线程的线程栈上
         */
        MySharedObject localVariable2 = MySharedObject.sharedInstance;

        //... do more with local variables.

        methodTwo();
    }

    public void methodTwo() {
        /**
         * localVariable1在对应线程的线程栈上
         */
        Integer localVariable1 = new Integer(99);

        //... do more with local variable.
    }

}
