package com.dynamic.interview.io.fragment;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author xinghuajian
 * @description 建立了流
 * @date 2019/4/26 10:25
 */
public class WriteDemo {
    public static void main(String[] args) {
        int b = 'A';
        System.out.write(b);
        System.out.write('\n');

        try {
            File f = new File("d:/lol.txt");
            /**
             *  创建基于文件的输入流,站在的角度的不同
             * 比如读取文件的数据到程序中，站在程序的角度来看，就叫做输入流
             **/
            FileInputStream fis = new FileInputStream(f);
            // 通过这个输入流，就可以把数据从硬盘，读取到Java的虚拟机中来，也就是读取到内存中

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
