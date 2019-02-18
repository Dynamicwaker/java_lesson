package com.dynamic.interview.algorithmtest.huawei;

import java.util.Scanner;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2019-02-02
 * @description 描述：
 * 明明的随机数 明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，他先用计算机生成了N个1到1000之间的随机整数（N≤1000），
 * 对于其中重复的数字，只保留一个，把其余相同的数去掉，不同的数对应着不同的学生的学号。
 * 然后再把这些数从小到大排序，按照排好的顺序去找同学做调查。请你协助明明完成“去重”与“排序”的工作。
 */
public class SortAndFilterNum {

    private static int MAINUM = 1001;

    public static int[] Test(int[] a) {
        int[] b = new int[MAINUM];
        for (int i = 0; i < MAINUM; i++) {
            b[i] = 0;
        }
        int len = a.length;
        // 把index等于数值的设为1，则达到了去重的目的，巧用数组记录、排序和去重
        for (int i = 0; i < len; i++) {
            b[a[i]] = 1;
        }
        return b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int[] c = Test(a);
            int len = c.length;
            for (int i = 0; i < len; i++) {
                if (c[i] == 1) {
                    System.out.println(i);
                }
            }
        }
    }
}
