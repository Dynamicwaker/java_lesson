package com.dynamic.algorithm.others.ch03;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/9/8.16:37
 * @description 字符栈
 */

public class MycharStack {

    private int maxSize;

    private char[] arr;
    /**
     * 栈顶元素指针
     */
    private int top;

    public MycharStack(int size) {
        maxSize = size;
        arr = new char[maxSize];
        top = -1;
    }

    /**
     * 压入数据
      */
    public void push(char value) {
        arr[++top] = value;
    }

    /**
     * 取数据
     */
    public char pop() {
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
