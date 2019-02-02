package com.dynamic.interview.algorithmtest.huawei;

import java.util.Scanner;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2019-02-02
 * @description 描述：计算字符串最后一个单词的长度，单词以空格隔开。
 */
public class StringSplitDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        findlastword(s);
    }

    public static void findlastword(String s) {
        String[] str = s.split(" ");
        int length = str.length;
        System.out.println(str[length - 1].length());
    }
}
