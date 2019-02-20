package com.dynamic.interview.algorithmtest.huawei;

import java.util.Scanner;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2019-02-19
 * @description 描述：写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
 */
public class Approximation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            double number = scan.nextDouble();
            int i = (int) number;
            System.out.println((number - i) >= 0.5 ? i + 1 : i);
        }
    }
}
