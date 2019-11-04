package com.dynamic.threadPic.ch17.jdkFuture;

import java.util.concurrent.Callable;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/11/24.17:22
 * @description jdk内置的future模式
 */

public class RealData implements Callable<String> {
    private String data;

    public RealData(String data) {
        this.data = data;
    }

    @Override
    public String call() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            sb.append(data + i).append(" ");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {

            }
        }
        return sb.toString();
    }

}
