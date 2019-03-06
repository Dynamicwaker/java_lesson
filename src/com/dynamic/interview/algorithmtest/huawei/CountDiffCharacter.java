package com.dynamic.interview.algorithmtest.huawei;

import java.util.Scanner;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2019-02-20
 * @description 描述：编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)。不在范围内的不作统计
 */
public class CountDiffCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            int len = getLen(s);
            System.out.println(len);
        }
    }

    public static int getLen(String s) {
        // 构造128长度的数组，如果存在，就将对应数组值设为1，去重和标记
        int[] arr = new int[128];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)] = 1;
        }
        int len = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                len++;
            }
        }
        return len;
    }
}
