package com.dynamic.interview.io.systematical.ch02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;

/**
 * @author xinghuajian
 * @description 利用inputstream
 * @date 2019/7/25 21:32
 */
public class FileOutputStreamDemo {

    public static void main(String[] args) throws IOException{
        inputReadStream();
    }

    public static void inputReadStream() throws IOException {
        InputStream inputStream = new FileInputStream("a.txt");
        FileOutputStream fos = new FileOutputStream("b.txt");
        byte[] b = new byte[1024];
        while ((inputStream.read(b)) != -1) {
            // 写入数据到文件，所以是输出流
            fos.write(b);
        }
        inputStream.close();
        // 保存数据
        fos.close();
    }

    public static void createFileToWriteInfo() {
        // 找到File类的实例
        File file = new File("文件路径");
        try {
            // 创建文件
            file.createNewFile();
            // 声明字符输出流
            Writer out = null;
            // 通过子类实例化，表示可以追加
            out = new FileWriter(file, true);
            // 写入数据
            out.write("文件内容");
            // 保存数据
            out.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
