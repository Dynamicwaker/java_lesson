package com.dynamic.algorithm.others.ch03;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/9/8.16:37
 * @description 数组实现栈
 */

public class MyStack {

    private int maxSize;

    private int[] arr;
    /**
     * 栈顶元素指针
     */
    private int top;

    public MyStack(int size) {
        maxSize = size;
        arr = new int[maxSize];
        top = -1;
    }

    /**
     * 压入数据
      */
    public void push(int value) {
        arr[++top] = value;
    }

    /**
     * 取数据
     */
    public long pop() {
        return arr[top--];
    }

    /**
     * 访问栈顶元素
     */
    public long peek() {
        return arr[top];
    }

    /**
     * 是否为空
      */
    public boolean isEmpty() {
        return (top == -1);
    }

    /**
     * 是否已满
      */
    public boolean isFull() {
        return (top == maxSize - 1);
    }

}
