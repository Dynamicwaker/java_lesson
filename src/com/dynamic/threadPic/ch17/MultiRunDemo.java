package com.dynamic.threadPic.ch17;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/10/28.10:19
 * @description 覆盖了Thread对象的run方法，同时传入一个Runnable的实现类(实现了其run方法)，会执行哪个？
 * 运行的实际上是直接覆写Thead类中run方法的代码，默认的run方法的逻辑是，如果传递了Runnable的实现类，就运行Runnable的run方法
 * 但是我们重写了Threadd的run()方法
 */

public class MultiRunDemo {

    public static void main(String[] args) {
        //传入了Runnable实现类
        new Thread(new MyRunnable()) {
            @Override
            public void run() {
                System.out.println("我是直接覆写Thread类run方法的代码...");
            }
        }.start();
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("我是实现Runnable接口的对象中的run方法的代码...");
        }
    }

}
