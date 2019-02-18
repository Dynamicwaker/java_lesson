package com.dynamic.interview.algorithmtest.huawei;

import java.util.Scanner;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2019-02-02
 * @description 描述：写出一个程序，接受一个有字母和数字以及空格组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
 */
public class CharNum {

    public static int findCharNum(String str, char key) {
        int count = 0;
        if (str == "" || str == null) {
            return 0;
        }
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.toLowerCase(chars[i]) == key || Character.toUpperCase(chars[i]) == key) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            // 搜索字符串
            String str = scanner.nextLine();
            // 目标对象
            String targetChar = scanner.nextLine();
            char key = targetChar.charAt(0);
            System.out.println(findCharNum(str, key));
        }
    }
}
