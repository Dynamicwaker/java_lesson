package com.dynamic.threadPic.ch14;


/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-10-21
 * @description 捕获程序整体的终止时,未设置异常处理，程序就停止，但是在停止前，“未设置异常处理器”和“退出钩子”会依次被调用
 */
public class TestMain {
    public static void main(String[] args) {
        System.out.println("main:BEGIN");
        // 1）设置未捕捉异常的处理器
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread thread, Throwable exception) {
                System.out.println("*****");
                System.out.println("UncaughtExceptionHandler:BEGIN");
                System.out.println("currentThread = " + Thread.currentThread().getName());
                System.out.println("thread = " + thread);
                System.out.println("exception = " + exception);
                System.out.println("UncaughtExceptionHandler:END");
            }
        });
        // 2）设置退出钩子
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.out.println("*****");
                System.out.println("shutdown hook:BEBIN");
                System.out.println("currentThread = " + Thread.currentThread().getName());
                System.out.println("shutdown hook:END");
            }
        });

        // 3秒后启动执行“整数除零计算”的线程
        new Thread("MyThread") {
            @Override
            public void run() {
                System.out.println("MyThread:BEGIN");
                System.out.println("MyThread:SLEEP...");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {

                }
                // [整数除零计算]
                System.out.println("MyThread:DIVIDE");
                int x = 1 / 0;
                // 不会来到这里
                System.out.println("MyThread:END");
            }
        }.start();
        System.out.println("main:END");
    }
}
