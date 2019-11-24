package com.dynamic.interview.algorithmtest.huawei;

import java.util.Scanner;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2019/3/20.11:39
 * @description 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。
 */

public class CountOne {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        while (n > 0) {
            // n&1等效于 n%2==1
            if ((n & 1) > 0) {
                count++;
            }
            // 向右移位
            n = n>>1;
        }
        System.out.println(count);
    }
}
