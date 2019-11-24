package com.dynamic.interview.others;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2019/3/30.14:43
 * @description java实现复制文件夹中的所有文件和文件夹到另一个文件夹中
 */

public class CopyDir {
    public static void main(String[] args) throws IOException{

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入源目录：");
        String sourcePath = sc.nextLine();
        System.out.println("请输入新目录：");
        String path = sc.nextLine();
        CopyDir.copyDir(sourcePath, path);
    }


    public static void copyDir(String sourcePath, String newPath) throws IOException {
        File file = new File(sourcePath);
        File newFile = new File(newPath);
        String[] filePath = file.list();
        if (!newFile.exists()) {
           newFile.mkdir();
        }

        for (int i = 0; i < filePath.length; i++) {
            // 如果是路径，还是执行copyDir
            if((new File(sourcePath + file.separator + filePath[i])).isDirectory()){
                copyDir(sourcePath  + file.separator  + filePath[i], newPath  + file.separator + filePath[i]);
            }
            if((new File(sourcePath + file.separator + filePath[i])).isFile()){
                copyFile(sourcePath  + file.separator  + filePath[i], newPath  + file.separator + filePath[i]);
            }
        }
    }

    public static void copyFile(String formerPath, String newPath) throws IOException {
        File oldfile = new File(formerPath);
        File newfile = new File(newPath);
        FileInputStream in = new FileInputStream(oldfile);
        FileOutputStream os = new FileOutputStream(newfile);
        byte[] bytes = new byte[20148 * 1024];
        int readByte = 0;
        while ((readByte = in.read(bytes)) != -1) {
            os.write(bytes, 0, readByte);
        }
        in.close();
        os.close();
    }
}
