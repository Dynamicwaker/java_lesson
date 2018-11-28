package com.dynamic.interview.foundation;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/11/28.23:40
 * @description 包装类缓存区区间
 * Boolean两个静态值
 * Byte，Short，Long，Integer都是 -128~127，Integer可调整
 * Character 0~127
 */

public class LongIntegerCacheTest {
    public static void main(String[] args) {
        Long a = 127L;
        Long b = 127L;
        System.out.println("Long max cached value is 127," + "and the result is:" + (a == b));

        Long a1 = 128L;
        Long b1 = 128L;
        System.out.println("Long = 128 cache is " + (a1 == b1));

        Long c = -128L;
        Long d = -128L;
        System.out.println("Long min cached value is -128, the result is:" + (c == d));

        Long c1 = -129L;
        Long d1 = -129L;
        System.out.println("Long = -129 cache is " + (c1 == d1));

        // jvm中可以设置AutoBoxCacheMax，只对Integer有效
        Integer x = 1001;
        Integer y = 1001;
        System.out.println("Integer = 1001 cache is " + (x == y));
    }
}
