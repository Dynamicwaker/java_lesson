package com.dynamic.interview.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches {

    public static void main(String args[]) {

        // 按指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";
        String patternDemo = "(\\D*)(\\d+)(.*)";

        /**
         * 创建 Pattern 对象
         * pattern 对象是一个正则表达式的编译表示。Pattern 类没有公共构造方法。要创建一个 Pattern 对象，
         * 你必须首先调用其公共静态编译方法，它返回一个 Pattern 对象
         */
        Pattern pattern = Pattern.compile(patternDemo);

        /**
         * 现在创建 matcher 对象
         * Matcher 对象是对输入字符串进行解释和匹配操作的引擎
         */
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            // m.group(0)等于子串自身
            System.out.println("Found value: " + matcher.group(0));
            System.out.println("Found value: " + matcher.group(1));
            System.out.println("Found value: " + matcher.group(2));
            System.out.println("Found value: " + matcher.group(3));
        } else {
            System.out.println("NO MATCH");
        }
    }
}
