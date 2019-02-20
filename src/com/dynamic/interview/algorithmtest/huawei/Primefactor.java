package com.dynamic.interview.algorithmtest.huawei;

import java.util.Scanner;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2019-02-18
 * @description 描述：功能:输入一个正整数，按照从小到大的顺序输出它的所有质数的因子（如180的质数因子为2 2 3 3 5 ）最后一个数后面也要有空格
 */
public class Primefactor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num = scanner.nextLong();
        System.out.println(getResult(num));
    }

    public static String getResult(long num) {
        int pum = 2;
        String result = "";
        while (num != 1) {
            while (num % pum == 0) {
                num = num / pum;
                result = result + pum + " ";
            }
            pum++;
        }
        return result;
    }
}
