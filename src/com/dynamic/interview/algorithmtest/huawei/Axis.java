package com.dynamic.interview.algorithmtest.huawei;


import java.util.Scanner;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2019/3/20.12:09
 * @description A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。从（0,0）点开始移动，
 * 从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
 * 坐标移动，合法坐标为A(或者D或者W或者S) + 数字（两位以内），坐标之间以;分隔。
 * 非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。
 */

public class Axis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            String[] targetStr = str.split(";");
            int x = 0, y = 0;
            for (String string : targetStr) {
                // 避免空字符串的异常
                if(!"".equals(string)) {
                    // 验证数字的正确性，向右移动
                    if (string.charAt(0) == 'D' && string.substring(1).matches("[0-9]+")) {
                        // 取后面的数字
                        x += Integer.parseInt(string.substring(1));
                    }
                    if (string.charAt(0) == 'W' && string.substring(1).matches("[0-9]+")) {
                        y += Integer.parseInt(string.substring(1));
                    }
                    if (string.charAt(0) == 'S' && string.substring(1).matches("[0-9]+")) {
                        y -= Integer.parseInt(string.substring(1));
                    }
                    if (string.charAt(0) == 'A' && string.substring(1).matches("[0-9]+")) {
                        x -= Integer.parseInt(string.substring(1));
                    }
                }
            }
            System.out.println(x + "," + y);
        }
    }
}
