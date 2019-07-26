package com.dynamic.interview.io.systematical.ch02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author xinghuajian
 * @description 输入流将文件中的内容输入到内存就是输入流
 * @date 2019/7/25 16:41
 */
public class InputStreamDemo {

    public static void main(String args[]) {
        // 第1步、使用File类找到一个文件
        File f = new File("d:" + File.separator + "test.txt");
        // 第2步、通过子类实例化父类对象，准备好一个输入的对象
        InputStream input = null;
        try {
            // 通过对象多态性，进行实例化
            input = new FileInputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // 第3步、进行读操作 所有的内容都读到此数组之中，读取内容，网络编程中read()方法会阻塞
        byte byteArr[] = new byte[1024];
        try {
            input.read(byteArr);
            // 第4步、关闭输出流
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 把byte数组变为字符串输出
        System.out.println("内容为：" + new String(byteArr));
    }

    /**
     * 读取filePath的文件，将文件中的数据按照行读取到String数组中
     *
     * @param filePath 文件的路径
     * @return 文件中一行一行的数据
     */
    public static String[] readToString(String filePath) {
        File file = new File(filePath);
        // 获取文件长度
        Long fileLength = file.length();
        byte[] fileContent = new byte[fileLength.intValue()];
        try {
            FileInputStream in = new FileInputStream(file);
            in.read(fileContent);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 返回文件内容,默认编码
        return new String(fileContent).split("\r\n");
    }

    /**
     * 使用InputStream从文件里读取数据，在已知文件大小的情况下，建立合适的存储字节数组
     */
    public static void readFileAlreadyKnow() {
        File f = new File("E:" + File.separator + "java2" + File.separator + "StreamDemo" + File.separator + "test.txt");
        InputStream in = null;
        try {
            in = new FileInputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //创建合适文件大小的数组
        byte b[] = new byte[(int) f.length()];
        //读取文件里的内容到b[]数组
        try {
            in.read(b);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(new String(b));
    }

    /**
     *  使用InputStream从文件里读取数据，在不知文件大小的情况下，循环读取文件
     */
    public static void readFileUnKnow() throws IOException {
        File f = new File("E:" + File.separator + "java2" + File.separator + "StreamDemo" + File.separator + "test.txt");
        InputStream in = null;
        try {
            in = new FileInputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //全部读取的内容都使用temp接收
        byte byteArr[] = new byte[1024];
        int len = 0;
        int temp;
        //当没有读取完时，继续读取
        while ((temp = in.read()) != -1) {
            byteArr[len++] = (byte) temp;
        }
        in.close();
        System.out.println(new String(byteArr, 0, len));
    }
}
