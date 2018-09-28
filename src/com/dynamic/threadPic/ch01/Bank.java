package com.dynamic.threadPic.ch01;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/9/28.22:29
 * @description 同步锁案例
 */

public class Bank {
    private String name;
    private int money;

    public Bank(String name, int money) {
        this.money = money;
        this.name = name;
    }

    public synchronized void deposit(int m) {
        money += m;
    }

    public synchronized boolean withdraw(int m) {
        if (money >= m) {
            money -= m;
            return true;
        } else {
            return false;
        }

    }

    public String getName() {
        return name;
    }

}
