package com.dynamic.threadPic.ch17;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/10/28.13:07
 * @description 如果在运行时代码中没有调用可以抛出中断异常的方法，那么我们必须频繁的调用Thread类的静态方法interrupted()来判断是否收到一个中断信号
 */

public class InteruptDemo2 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                int i = 0;
                while (true) {
                    //每次打印前都判断是否被中断
                    if (!Thread.interrupted()) {
                        i++;
                        System.out.println("自定义线程，打印...." + i + "次");
                    } else {//如果被中断，停止运行
                        System.out.println("自定义线程：被中断...");
                        return;
                    }

                }

            }
        };
        thread.start();
        //主线程休眠1毫秒，以便自定义线程执行
        Thread.sleep(1);
        System.out.println("主线程:休眠1毫秒后发送中断信号...");
        thread.interrupt();
    }
}