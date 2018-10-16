package com.dynamic.threadPic.ch12;

import java.util.Random;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/10/16.21:19
 * @description 表示工作请求的类
 */

public class Request {
    private final String name;
    private final int number;
    private static final Random random = new Random();

    public Request(String name, int number) {
        // 委托者
        this.name = name;
        // 请求的编号
        this.number = number;
    }

    public void execute() {
        System.out.println(Thread.currentThread().getName() + " executes " + this);
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {

        }
    }

    @Override
    public String toString() {
        return "[ Request from " + name + " No." + number + " ]";

    }
}
