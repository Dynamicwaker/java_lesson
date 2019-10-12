package com.dynamic.algorithm.others.ch03;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/9/8.17:46
 * @description 测试
 */

public class TestAll {
    public static void main(String[] args) {
        Reverse re = new Reverse("Hello,bitch!");
        System.out.println(re.doReverse());

        Reverse re2 = new Reverse("12345");
        System.out.println(re2.doReverse());
    }
}

