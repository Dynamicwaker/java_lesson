package com.dynamic.interview.io.systematical.ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author xinghuajian
 * @description:BufferedReader 是缓冲字符输入流，它继承于Reader，它的作用是为其他字符输入流添加一些缓冲功能
 * @date 2019/7/26 16:23
 */
public class BufferedReaderDemo {
    public static void main(String args[]) {
        // 将字节流变为字符流
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        // 接收输入内容
        String str = "";
        System.out.print("请输入内容：");
        try {
            // 读取一行数据
            str = buf.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 输出信息
        System.out.println("输入的内容为：" + str);
    }
}
