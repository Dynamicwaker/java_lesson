package com.dynamic.interview.algorithmtest.huawei;

import java.util.Scanner;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2019-02-20
 * @description 描述：输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 */
public class Right2LeftNoRepeat {
    public static void main(String[] args) {
        /**
         * 利用一个10大小的数组（0-9一共10个），如果位置为0，说明没有碰到过这个数字，则输出元素，
         * 然后数组的值加1，说明这个碰到过这个数字。字符与整数之间差48，比如0的字符为48
         */
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            int len = s.length();
            int[] arrTemp = new int[10];
            for (int i = len - 1; i >= 0; i--) {
                if (arrTemp[s.charAt(i) - 48] == 0) {
                    System.out.print(s.charAt(i) - 48);
                    arrTemp[s.charAt(i) - 48]++;
                }
            }
        }
    }
}
