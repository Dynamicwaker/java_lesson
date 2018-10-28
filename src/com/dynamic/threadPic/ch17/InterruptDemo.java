package com.dynamic.threadPic.ch17;

import java.util.Date;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/10/28.12:52
 * @description 自定义线程的确是打印出两次当前时间后就停止了运行，
 * 根本原因在于，我们在收到中断信号后，在catch代码中使用了return，结束了方法
 */

public class InterruptDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(4000);
                        System.out.println("自定义线程:当前时间：" + new Date().toLocaleString());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        System.out.println("自定义线程:收到中断信号，总共循环了" + i + "次...");
                        //接受到中断信号时，停止运行
                        return;
                    }
                }
            }
        };
        thread.start();
        // 主线程休眠9s
        Thread.sleep(9000);
        System.out.println("主线程：等待9秒后发送中断信号...");
        thread.interrupt();
    }
}
