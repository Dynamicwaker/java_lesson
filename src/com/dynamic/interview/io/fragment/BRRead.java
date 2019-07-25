package com.dynamic.interview.io.fragment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description: java BufferedReader从后台读取字符
 * @Author: dynamic2xhj@163.com
 * @CreateDate: 2019/4/23 20:51
 * @Version: 1.0
 */
public class BRRead {
    public static void main(String[] args) throws IOException {
        char c;
        // 使用 System.in 创建 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入字符, 按下 'q' 键退出。");
        do {
            c = (char) br.read();
            System.out.println(c);
        } while (c != 'q');
    }
}
