package com.dynamic.threadPic.ch01;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-10-26
 * @description join方法，其作用是：在A线程中调用了另外一个线程对象B的join方法时，那么A线程必须等待B线程执行完才能继续往下执行。
 * join可以理解为"插队"
 */
public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        System.out.println("程序开始运行...");
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    // 模拟自定义线程干某个事花了5秒
                    System.out.println("自定义线程执行开始...");
                    Thread.sleep(5000);
                    System.out.println("自定义线程执行完毕...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();

        // 模拟主线干其他事花了2秒
        Thread.sleep(2000);
        System.out.println("主线程执行完毕，等待t线程执行完成...");
        // 主线程2秒后就可以继续执行，但是其必须执行的条件是t线程必须执行完成，此时调用t的join方法
        long joinStart = System.currentTimeMillis();
        t.join();
        System.out.println("主线程：t执行已经执行完毕...，等待了" + (System.currentTimeMillis() - joinStart) / 1000 + "秒");
        System.out.println("程序运行总时间..." + (System.currentTimeMillis() - start) / 1000 + "秒");
    }
}
