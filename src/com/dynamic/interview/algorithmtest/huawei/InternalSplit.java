package com.dynamic.interview.algorithmtest.huawei;

import java.util.Scanner;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2019-02-18
 * @description 描述：1、连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；2、长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 */
public class InternalSplit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = new String(sc.nextLine());
            if (s.length() % 8 != 0) {
                s = s + "00000000";
            }
            // 小于8个字符，就不存在输入字符了，因为末尾加了8个0补足
            while (s.length() >= 8) {
                System.out.println(s.substring(0, 8));
                s = s.substring(8);
            }
        }
    }
}
