package com.dynamic.threadPic.ch09;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-10-14
 * @description Producer-Consumer模式，生产者和消费者都只有一个时，称为Pipe模式
 *
 */
public class Main {
    public static void main(String[] args) {
        Table table = new Table(3);
        new MakerThread("MakerThread-1",table,31415).start();
        new MakerThread("MakerThread-2",table,92653).start();
        new MakerThread("MakerThread-3",table,58979).start();
        new EaterThread("EaterThread-1",table,32484).start();
        new EaterThread("EaterThread-2",table,62643).start();
        new EaterThread("EaterThread-3",table,38327).start();
    }
}
