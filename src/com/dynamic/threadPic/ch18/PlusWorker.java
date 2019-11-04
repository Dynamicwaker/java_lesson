package com.dynamic.threadPic.ch18;

/**
 * @author xinghuajian
 * @description
 * @date 2019/10/23 10:29
 */
public class PlusWorker extends Worker {

    @Override
    public Object handle(Object input) {
        Integer i = (Integer) input;
        return i * i * i;
    }
}
