package com.dynamic.threadPic.ch17;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/10/28.17:35
 * @description 1、thread.setDaemon(true)必须在thread.start()之前设置，你不能把正在运行的常规线程设置为守护线程；
 * 2、在Daemon线程中产生的新线程也是Daemon的
 * 3、JVM会在所有执行的线程都是守护线程的时候退出。
 * 所给例子中的执行结果是：文件daemon.txt中没有"daemon"字符串。
 */

public class DaemonThreadDemo {

    public static void main(String[] args) throws InterruptedException {
        Runnable tr = new TestRunnable();
        Thread thread = new Thread(tr);
        thread.setDaemon(true); //设置守护线程
        thread.start(); //开始执行分进程
    }
}
