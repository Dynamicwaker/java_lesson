package com.dynamic.threadPic.ch12;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/10/16.21:19
 * @description
 */

public class WorkThread extends Thread {
    private final Channel channel;

    public WorkThread(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {
        while (true) {
            Request request = channel.takeRequest();
            request.execute();
        }
    }
}
