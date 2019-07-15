package com.dynamic.threadPic.ch17;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/11/14.23:36
 * @description Condition条件
 */

public class ReenterLockCondition implements Runnable {

    public static ReentrantLock lock = new ReentrantLock();
    public static Condition condition = lock.newCondition();

    @Override
    public void run() {
        try {
            lock.lock();
            condition.await();
            System.out.println("Thread is going on");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLockCondition tl = new ReenterLockCondition();
        Thread t2 = new Thread(tl);
        t2.start();
        Thread.sleep(2000);
        // 通知线程t2继续前进，singal()和await()方法都需要获得锁，类似于notify()和wait()
        lock.lock();
        condition.signal();
        lock.unlock();
    }
}
