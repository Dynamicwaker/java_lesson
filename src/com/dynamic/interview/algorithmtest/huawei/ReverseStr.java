package com.dynamic.interview.algorithmtest.huawei;

import java.util.Scanner;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2019/3/20.9:57
 * @description 输入一个整数，将这个整数以字符串的形式逆序输出，程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 */

public class ReverseStr {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.reverse();
        System.out.println(stringBuilder.toString());
    }
}
