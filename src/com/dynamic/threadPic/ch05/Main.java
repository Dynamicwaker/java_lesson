package com.dynamic.threadPic.ch05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-10-12
 * @description 集合类与多线程demo
 */
public class Main {
    public static void main(String[] args) {
        // 方式一：ArrayList<Integer>()非线程安全
        // List<Integer> list = new ArrayList<Integer>();
        // 方式二：线程安全的synchronizedList
        // final List<Integer> list = Collections.synchronizedList(new ArrayList<Integer>());
        // 方式三：线程安全CopyOnWriteArrayList，方式二和三的选择需要根据现实情况
        final List<Integer> list =  new CopyOnWriteArrayList<Integer>();
        new WriterThread(list).start();
        new ReaderThread(list).start();
    }
}
