package com.dynamic.threadPic.ch12;

import java.util.Random;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/10/16.21:19
 * @description
 */

public class ClientThread extends Thread {
    private final Channel channel;
    private static final Random random = new Random();

    public ClientThread(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; true; i++) {
                Request request = new Request(getName(), i);
                channel.putRequest(request);
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {

        }
    }
}
