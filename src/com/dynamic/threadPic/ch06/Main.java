package com.dynamic.threadPic.ch06;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/10/13.22:53
 * @description Guarded suspension模式demo，如果执行现在的处理有问题，则让执行处理的线程进行暂停等待
 */

public class Main {
    public static void main(String[] args) {
        RequestQueue requestQueue = new RequestQueue();
        new ClientThread(requestQueue,"Alice",3141592L).start();
        new ServerThread(requestQueue,"Bobby",6535897L).start();
    }
}
