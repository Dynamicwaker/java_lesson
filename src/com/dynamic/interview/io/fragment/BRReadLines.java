package com.dynamic.interview.io.fragment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description: 从控制台读取字符串
 * @Author: dynamic2xhj@163.com
 * @CreateDate: 2019/4/23 20:57
 * @Version: 1.0
 */
public class BRReadLines {
    public static void main(String[] args) throws IOException {
        // 使用 System.in 创建 BufferedReader
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        System.out.println("Enter lines of text.");
        System.out.println("Enter 'end' to quit.");
        do {
            str = bufferedReader.readLine();
            System.out.println(str);
        } while (!"end".equals(str));
    }
}
