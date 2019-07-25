package com.dynamic.interview.io.fragment;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @Description: java 文件常用方法
 * @Author: dynamic2xhj@163.com
 * @CreateDate: 2019/4/23 20:02
 * @Version: 1.0
 */
public class TestFile {
    public static void main(String[] args) throws IOException {
        File f = new File("D:/LOLFolder/LOL.exe");
        System.out.println("当前文件是：" + f);

        System.out.println("判断是否存在：" + f.exists());

        System.out.println("判断是否是文件夹：" + f.isDirectory());

        System.out.println("判断是否是文件：" + f.isFile());

        System.out.println("获取文件的长度：" + f.length());

        long time = f.lastModified();
        Date d = new Date(time);
        System.out.println("获取文件的最后修改时间：" + d);
        //设置文件修改时间为1970.1.1 08:00:00
        f.setLastModified(0);
        //文件重命名
        File f2 = new File("D:/LOLFolder/DOTA.exe");
        f.renameTo(f2);
        System.out.println("把LOL.exe改名成了DOTA.exe");

        System.out.println("********************************");

        File f3 = new File("D:/LOLFolder/skin/garen.ski");
        // 以字符串数组的形式，返回当前文件夹下的所有文件（不包含子文件及子文件夹）
        System.out.println(f3.list());
        // 以文件数组的形式，返回当前文件夹下的所有文件（不包含子文件及子文件夹）
        File[] fs = f3.listFiles();
        // 以文件形式返回获取所在文件夹
        f3.getParentFile();
        // 创建文件夹，如果父文件夹skin不存在，创建就无效
        f3.mkdir();
        // 创建文件夹，如果父文件夹skin不存在，就会创建父文件夹
        f3.mkdirs();

        // 创建一个空文件,如果父文件夹skin不存在，就会抛出异常
        f3.createNewFile();
        // 所以创建一个空文件之前，通常都会创建父目录
        f3.getParentFile().mkdirs();
        // 列出所有的盘符c: d: e: 等等
        File.listRoots();
        // 刪除文件
        f3.delete();
        // JVM结束的时候，刪除文件，常用于临时文件的删除
        f3.deleteOnExit();
    }
}
