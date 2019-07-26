package com.dynamic.interview.io.systematical.ch01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author xinghuajian
 * @description 文件操作
 * @date 2019/7/25 09:55
 */
public class CreateFile {

    private static String fileDir = "D:" + File.separator + "hello.txt";

    public static void main(String[] args) {
        //deleteFile();
        //mkdir();
        //listFile();
        //randomFile();
        //writeStrIntoFile();
        //createFileMethodOne();
        appendInfoToFile();
        readFile();
    }

    /**
     * 创建新文件方法一：绝对路径创建
     */
    public static void createFileMethodOne() {
        File f = new File("D:\\hello.txt");
        try {
            f.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建新文件方法二：相对路径创建
     */
    public static void createFileMethodTwo() {
        try {
            // 获取目录“dir”对应的File对象
            File dir = new File("dir");
            File file1 = new File(dir, "file1.txt");
            file1.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建新文件方法三：相对路径创建
     */
    public static void createFileMethodThree() {
        try {
            File file2 = new File("dir", "file2.txt");
            file2.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建新文件方法四：绝对路径方式创建
     */
    public static void createFileMethodFour() {
        try {
            URI uri = new URI("file:/home/xing/dir/file4.txt");
            File file4 = new File(uri);
            file4.createNewFile();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
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
     * 可以根据相对路径/绝对路径/URI方式创建
     */
    public static void mkdir() {
        File file = new File(fileDir);
        file.mkdir();
    }

    /**
     * 创建子目录
     * 它不需要dir已经存在，也能正常运行；若“sub4”的父母路不存在，mkdirs()方法会自动创建父目录
     */
    public static void mkSubDir() {
        URI uri = null;
        try {
            uri = new URI("file:/home/skywang/dir/sub5");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        File sub5 = new File(uri);
        sub5.mkdirs();
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
            // byte类型的数组，数组长度为1024。也就是说你最多可以存1024个字节
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
