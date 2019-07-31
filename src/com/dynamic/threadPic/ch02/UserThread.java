package com.dynamic.threadPic.ch02;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/10/1.22:58
 * @description 不断通过的人
 */

public class UserThread extends Thread {
    /**
     * 空白final，不在字段声明时赋值，在构造函数中将字段值初始化的形式
     */
    private final Gate gate;
    private final String myName;
    private final String myAddress;

    public UserThread(Gate gate, String myName, String myAddress) {
        this.gate = gate;
        this.myName = myName;
        this.myAddress = myAddress;
    }

    @Override
    public void run() {
        System.out.println(myName + " BEGIN");
        while (true) {
            gate.pass(myName, myAddress);
        }
    }
}
