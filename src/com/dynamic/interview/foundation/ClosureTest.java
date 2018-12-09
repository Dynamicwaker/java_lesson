package com.dynamic.interview.foundation;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-12-09
 * @descriptio 内部类的局部变量修饰成final
 * 因为局部变量，它的作用域在停停留在该方法里，当方法执行结束，随之消失，但是内部类可能会产生隐式的闭包，是局部变量脱离方法存在
 */
public class ClosureTest {
    public static void main(String[] args) {
        final String str = "java";
        new Thread(new Runnable() {
            /**
             * 只要新的线程方法没有执行完的话，匿名嫩不累的实例的生命周期就没有结束，
             * 将一直可以访问str局部变量的值，这样内部类会扩大局部变量的作用域
             */
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(str + "-" + i);
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
