package com.dynamic.interview.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author xinghuajian
 * @description
 * @date 2019/4/26 10:27
 */
public class fileStreamTest {
    public static void main(String[] args) {
        try {
            byte bWrite[] = {'a', 'h', 'e', 'l', 'l', 'o'};
            OutputStream outputStream = new FileOutputStream("test.txt");
            for (int i = 0; i < bWrite.length; i++) {
                outputStream.write(bWrite[i]);
            }
            outputStream.close();
            InputStream is = new FileInputStream("test.txt");
            int size = is.available();

            for (int i = 0; i < size; i++) {
                System.out.print((char) is.read() + "  ");
            }
            is.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
