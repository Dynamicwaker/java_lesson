package com.dynamic.threadPic.ch17;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/10/28.14:34
 * @description 从结果中我们好像看到优先级高的线程P10好像并没有比优先级低的线程P1在执行的时候有什么优势。
 * 这是因为线程的执行是抢占式的，优先级高的线程只是理论上会更优先的获取执行的机会，但并不意味着一定优先执行。
 */

public class PriorityDemo2 {

    public static void main(String[] args) {
        //创建线程t2并将优先级设为10
        Thread t1 = new Thread("P10") {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + ":执行" + i + "次");
                }
            }
        };
        t1.setPriority(Thread.MAX_PRIORITY);
        //创建线程t2并将优先级设为1
        Thread t2 = new Thread("P1") {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + ":执行" + i + "次");
                }
            }
        };
        t2.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
    }
}
