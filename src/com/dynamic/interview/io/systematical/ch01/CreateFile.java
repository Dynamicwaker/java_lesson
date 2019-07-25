package com.dynamic.interview.io.systematical.ch01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;

/**
 * @author xinghuajian
 * @description
 * @date 2019/7/25 09:55
 */
public class CreateFile {

    private static String fileDir = "D:" + File.separator + "hello.txt";

    public static void main(String[] args) {
        //createFile();
        //deleteFile();
        //mkdir();
        //listFile();
        //randomFile();
        //writeStrIntoFile();
        appendInfoToFile();
        readFile();
    }

    /**
     * 创建新文件
     */
    public static void createFile() {
        File f = new File("D:\\hello.txt");
        try {
            f.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除文件
     */
    public static void deleteFile() {
        File f = new File(fileDir);
        if (f.exists()) {
            f.delete();
        } else {
            System.out.println("文件不存在");
        }
    }

    /**
     * 创建一个文件夹
     */
    public static void mkdir() {
        File file = new File(fileDir);
        file.mkdir();
    }

    /**
     * 列出指定目录的全部文件（包括隐藏文件）
     */
    public static void listFile() {
        String fileName = "D:" + File.separator;
        File file = new File(fileName);
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i]);
        }
    }

    /**
     * 使用RandomAccessFile写入文件
     */
    public static void randomFile() {
        File f = new File(fileDir);
        try {
            RandomAccessFile demo = new RandomAccessFile(f, "rw");
            demo.writeBytes("asdsad");
            demo.writeInt(12);
            demo.writeBoolean(true);
            demo.writeChar('A');
            demo.writeFloat(1.21f);
            demo.writeDouble(12.123);
            demo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 写入字符到文件，对于文件来说，是写入，对于程序来说是输出
     * 为了把内存里的东西转到文件，是写，是输出流
     * 为了把文件上的内容转到内存，是读，是输入流
     */
    public static void writeStrIntoFile() {
        File file = new File(fileDir);
        try {
            OutputStream out = new FileOutputStream(file);
            String str = "你好";
            byte[] b = str.getBytes();
            out.write(b);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 追加插入信息
     */
    public static void appendInfoToFile() {
        File file = new File(fileDir);
        try {
            OutputStream out = new FileOutputStream(file);
            String str = "Rollen";
            byte[] b = str.getBytes();
            for (int i = 0; i < b.length; i++) {
                out.write(b[i]);
            }
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取文件
     */
    public static void readFile() {
        File file = new File(fileDir);
        try {
            InputStream inputStream = new FileInputStream(file);
            byte[] byteArr = new byte[1024];
            int count = 0;
            int temp;
            // 读取Rollen，解析到对应字符的ASCII码 比如"R“为82，”o“为111,"l"为108
            while ((temp = inputStream.read()) != -1) {
                byteArr[count++] = (byte) temp;
            }
            inputStream.close();
            System.out.println(new String(byteArr));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
