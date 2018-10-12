package com.dynamic.threadPic.ch05;

import java.util.List;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-10-12
 * @description 多线程访问Arraylist
 */
public class WriterThread extends Thread {
    private final List<Integer> list;

    public WriterThread(List<Integer> list) {
        super("WriterThread");
        this.list = list;
    }

    @Override
    public void run(){
        for(int i=0;true;i++){
            list.add(i);
            list.remove(0);
        }
    }
}
