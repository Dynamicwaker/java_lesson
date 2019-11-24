package com.dynamic.interview.algorithmtest.huawei;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2019/3/20.14:23
 * @description 密码要求:
 * 1.长度超过8位
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 * 3.不能有相同长度超2的子串重复
 * 说明:长度超过2的子串
 */
public class CheckCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            if (isLengthQualified(str) && isContentQualified(str) && !hasDuplicatedString(str)) {
                System.out.println("OK");
            } else {
                System.out.println("NG");
            }
        }
        sc.close();
    }

    public static boolean isLengthQualified(String s) {
        return s.length() > 8;
    }

    public static boolean isContentQualified(String s) {
        int count = 0;
        String[] str = {"[a-z]", "[A-Z]", "[0-9]", "[^a-zA-Z0-9]"};
        for (int i = 0; i < str.length; i++) {
            Pattern pattern = Pattern.compile(str[i]);
            Matcher matcher = pattern.matcher(s);
            if (matcher.find()) {
                count++;
            }
        }
        return count >= 3;
    }

    public static boolean hasDuplicatedString(String s) {
        for (int i = 0; i < s.length() - 3; i++) {
            if (s.substring(i + 3).contains(s.substring(i, i + 3))) {
                return true;
            }
        }
        return false;
    }
}

