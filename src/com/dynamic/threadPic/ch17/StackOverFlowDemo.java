package com.dynamic.threadPic.ch17;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/10/30.22:51
 * @description 栈内存溢出(StackOverflowError)问题
 * 线程在执行的时候，会直接调用一系列的方法，而被直接调用的方法可能又调用了其他的方法。
 * 为了保证直接或者间接被调用的方法可以按照方法声明的顺序那样进行执行，每个线程都在栈内存中维护了一个数据结构，就是一个栈。
 * 一个线程在执行的时候，每当遇到一个方法的开始，就将这个方法的相关信息(称之为栈帧)压入栈，而方法结束后再进行弹栈。通过这种方式保证了方法执行顺序的正确性。
 * 但是因为栈内存的大小是有限制的，默认请下一般是1M。
 * 当我们再使用递归方法的时候，方法会存在不断的循环调用，因此会不断的往栈中压入数据，当数据量超过1M的时候，就会出现栈内存溢出。
 * 所以java开发中要慎用递归，要注意收敛条件
 */

public class StackOverFlowDemo {
    int count = 0;

    public void recursiveMethod() {
        if (count == 1000000) {//递归方法执行1000000次时，结束
            return;
        }
        count++;
        System.out.println("执行了:" + count + "次");
        recursiveMethod();//递归调用
    }

    public static void main(String[] args) {
        StackOverFlowDemo stackOverFlowDemo = new StackOverFlowDemo();
        stackOverFlowDemo.recursiveMethod();
        System.out.println("执行其他代码...");
    }
}
