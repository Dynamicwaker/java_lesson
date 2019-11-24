package com.dynamic.interview.io;

import java.io.File;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2019/4/8.20:06
 * @description 创建文件对象
 */

public class TestFile {
    public static void main(String[] args) {
        File f1 = new File("d:/LOLFolder");
        // 获取绝对路径
        System.out.println("f1的绝对路径是："+f1.getAbsolutePath());
        File f2 = new File("LOL.exe");
        // 相对路径,相对于工作目录，如果在eclipse中，就是项目目录
        System.out.println("f1的绝对路径是："+f2.getAbsolutePath());
        // 把f1作为父目录创建文件对象
        File f3 = new File(f1, "LOL.exe");

        System.out.println("f3的绝对路径：" + f3.getAbsolutePath());
    }
}
