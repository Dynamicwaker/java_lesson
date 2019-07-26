package com.dynamic.interview.io.systematical.ch03;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * @author xinghuajian
 * @description 输出流
 * @date 2019/7/26 11:48
 */
public class OutputStreamDemo {
    public static void main(String args[]) throws Exception {
        // 第1步、使用File类找到一个文件
        File f = new File("d:" + File.separator + "test.txt");
        // 第2步、通过子类实例化父类对象
        OutputStream out;
        // 通过对象多态性，进行实例化
        out = new FileOutputStream(f);
        // 第3步、进行写操作，准备一个字符串
        String str = "Hello World!!!";
        // 只能输出byte数组，所以将字符串变为byte数组
        byte[] byteArr = str.getBytes();
        // 将内容输出，保存文件
        out.write(byteArr);
        // 第4步、关闭输出流
        out.close();
        //文件不存在会自动创建
    }
}
