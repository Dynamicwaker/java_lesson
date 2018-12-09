package com.dynamic.interview.foundation;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-12-09
 * @description 调用父类构造器
 */
public class Derived extends Base {
    private int i = 22;

    public Derived() {
        i = 222;
    }

    @Override
    public void display() {
        System.out.println(i);
    }

    public static void main(String[] args) {
        /**
         *  此处打印比较奇怪是：0
         */
        new Derived();
    }
}
