package com.dynamic.threadPic.ch17;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/10/30.22:55
 * @description 自旋锁，自旋锁不是真正的锁，其只是解决思路的一种方式，只要不能继续往下执行，就不断的循环。
 */

public class StackOverFlowSpinLocDemo {

    int count = 0;

    public void incr() {
        count++;
        System.out.println("执行了:" + count + "次");

    }

    public static void main(String[] args) {
        StackOverFlowSpinLocDemo spinLockDemo = new StackOverFlowSpinLocDemo();
        while (spinLockDemo.count != 1000000) {//这段代码其实就是一个自旋锁
            spinLockDemo.incr();
        }
        System.out.println("执行其他代码...");
    }
}
