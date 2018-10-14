package com.dynamic.threadPic.ch07;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-10-14
 * @description balking模式：如果现在不适合执行这个操作，或者说没有必要，就停止处理，并直接返回
 * 类似于Guarded suspension模式，但是守护条件不成立时，立即返回
 * 使用情境：
 * 1、并不需要执行时 2.不需要等待守护条件成立时 3.守护条件仅在第一次成立时
 * balk结果的表示方式：1.忽略balk 2.通过返回值 3.通过异常俩表示balk的发生
 */
public class Main {
    public static void main(String[] args) {
        Data data = new Data("data.txt", "(empty)");
        new ChangerThread("ChangerThread", data).start();
        new SaverThread("SaverThread", data).start();
    }
}
