package com.dynamic.threadPic.ch17;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-11-13
 * @description
 */
public class ThreadGroupName implements Runnable {
    public static void main(String[] args) {
        ThreadGroup tg = new ThreadGroup("PrintGroup");
        Thread t1 = new Thread(tg, new ThreadGroupName(), "T1");
        Thread t2 = new Thread(tg, new ThreadGroupName(), "T2");
        t1.start();
        t2.start();
        // 可以获得的活动线程的总数
        System.out.println(tg.activeCount());
        tg.list();

    }

    @Override
    public void run() {
        String groupAndName = Thread.currentThread().getThreadGroup().getName() + "-" + Thread.currentThread().getName();
        while (true) {
            System.out.println("I am " + groupAndName);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
