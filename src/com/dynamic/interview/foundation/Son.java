package com.dynamic.interview.foundation;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/11/26.22:19
 * @description 子类
 */

public class Son extends Parent {
    static {
        System.out.println("Son 静态代码块");
    }

    public Son() {
        System.out.println("Son 构造方法");
    }

    public static void main(String[] args) {
        // 静态代码块优先执行，然后父类构造方法，子类构造方法，静态代码只运行一次
        new Son();
        new Son();
    }
}
