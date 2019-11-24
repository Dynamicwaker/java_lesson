package com.dynamic.interview.foundation;

import java.util.Scanner;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2019/3/5.23:16
 * @description 输入home，发现第二个字符未被截取到，因为对输入有效字符之前遇到的空格键、Tab键或Enter键等结束符，next（）方法会自动将其去掉
 * home的回车被nextLine捕获，所以直接输出
 * 所以什么是有效字符
 * 请输入第一个字符：home
 * 请输入第二个字符：输入的字符依次是：home
 * next() 是以空格和回车作为分割符进行读取的，如果一行输入包含空格，会按空格截断，只显示第一个空格之前的内容
 * nextLine()是以回车作为分割符进行读取 也就是说会从控制台接收控制台输入的一行数据，读入语句包含空格
 */

public class NextTest {
    public static void main(String[] args) {
        String s1, s2;
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入第一个字符：");
        s1 = sc.next();
        System.out.print("请输入第二个字符：");
        s2 = sc.nextLine();
        System.out.println("输入的字符依次是：" + s1 + s2);
    }
}
