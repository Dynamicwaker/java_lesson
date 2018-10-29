package com.dynamic.threadPic.ch17;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-10-29
 * @description
 */
public class ObjectLock {
    public static void main(String[] args) {
        System.out.println("start time = " + System.currentTimeMillis() + "ms");
        LockTestClass test = new LockTestClass();
        for (int i = 0; i < 3; i++) {
            Thread thread = new ObjThread(test, i);
            thread.start();
        }
    }
}
