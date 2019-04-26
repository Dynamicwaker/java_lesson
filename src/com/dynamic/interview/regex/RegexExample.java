package com.dynamic.interview.regex;

import java.util.regex.Pattern;

public class RegexExample {

    public static void main(String[] args) {
        String content = "I am dool " + "from dool.com.";
        String pattern = ".*dool.*";
        /**
         * 在content里面找满足的pattern的子串
         */
        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println("字符串中是否包含了 'dool.'的子字符串? " + isMatch);
    }
}
