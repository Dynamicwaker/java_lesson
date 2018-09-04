package com.dynamic.interview;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-09-04
 * @description 中间缓存变量机制
 */
public class TestDemo2 {
    public static void main(String[] args) {
        int j = 0;
        for (int i = 0; i < 100; i++) {
            // j = j ++ 等效于 temp = j;j++;j = temp
            j = j++;
        }
        System.out.println("j = " + j);
    }
}
