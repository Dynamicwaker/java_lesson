package com.dynamic.interview.io.systematical.ch03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author xinghuajian
 * @description 处理流InputStreamReader，处理流就是在输出流上包一层
 * @date 2019/7/26 20:58
 */
public class InputStreamReaderDemo {
    public static void transReadNoBuf() throws IOException {
        /**
         * 没有缓冲区，只能使用read()方法。
         */
        //读取字节流
        //InputStream in = System.in;//读取键盘的输入。
        //读取文件的数据。
        InputStream in = new FileInputStream("D:\\demo.txt");
        //将字节流向字符流的转换。要启用从字节到字符的有效转换，
        //可以提前从底层流读取更多的字节.
        InputStreamReader isr = new InputStreamReader(in);
        //综合到一句。
        //InputStreamReader isr = new InputStreamReader(
        //new FileInputStream("D:\\demo.txt"));

        char []cha = new char[1024];
        int len = isr.read(cha);
        System.out.println(new String(cha,0,len));
        isr.close();

    }
    public static void transReadByBuf() throws IOException {
        /**
         * 使用缓冲区 可以使用缓冲区对象的 read() 和  readLine()方法。
         */
        //读取字节流
        //InputStream in = System.in;//读取键盘上的数据
        //读取文件上的数据。
        InputStream in = new FileInputStream("D:\\demo.txt");
        //将字节流向字符流的转换。
        InputStreamReader isr = new InputStreamReader(in);
        //创建字符流缓冲区
        BufferedReader bufr = new BufferedReader(isr);

        String line;
        while((line = bufr.readLine())!=null){
            System.out.println(line);
        }
        isr.close();
    }
}
