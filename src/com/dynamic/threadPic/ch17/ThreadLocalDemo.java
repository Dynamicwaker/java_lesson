package com.dynamic.threadPic.ch17;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/11/18.22:50
 * @description ThreadLocal, 作为简单的容器，只有当前线程可以访问
 */

public class ThreadLocalDemo {

    static ThreadLocal<SimpleDateFormat> t1 = new ThreadLocal<>();

    public static class ParseDate implements Runnable {
        int i = 0;

        public ParseDate(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                if (t1.get() == null) {
                    t1.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
                }
                Date t = t1.get().parse("2015-03-29 19:29:" + i % 60);
                System.out.println(i + ":" + t);
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
    }


    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int j = 0; j < 1000; j++) {
            es.execute(new ParseDate(j));
        }
    }
}
