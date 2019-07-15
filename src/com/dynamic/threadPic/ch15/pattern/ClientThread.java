package com.dynamic.threadPic.ch15.pattern;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-10-22
 * @description 表示调用Log.println和Log.close的线程的方法, 作为委托者
 */
public class ClientThread extends Thread {

    public ClientThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(getName() + " BEGIN");
        for (int i = 0; i < 10; i++) {
            Log.println("i = " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {

            }
        }
        Log.close();
        System.out.println(getName() + " END");
    }
}
