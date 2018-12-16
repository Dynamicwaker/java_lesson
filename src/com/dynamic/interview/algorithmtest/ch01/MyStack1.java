package com.dynamic.interview.algorithmtest.ch01;

import java.util.Stack;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/12/16.20:43
 * @description 实现一个特殊的栈，在实现基本功能的基础上，返回栈中的最小元素的操作
 * 使用两个栈来实现，一个是最小值的栈，一个是元素的栈
 */

public class MyStack1 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack1() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(int newNum) {
        // 最小值的栈只有最小值栈中没有值，或者栈中最小值大于等于插入值时才需要push，等于是一个临界点
        if (this.stackMin.isEmpty()) {
            this.stackMin.push(newNum);
        } else if (newNum <= this.getMin()) {
            this.stackMin.push(newNum);
        }
        // 元素栈不需要判断直接塞入
        this.stackData.push(newNum);

    }

    public int pop() {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("your stack is empty!");
        }
        // 只有当pop的是最小值时，最小值栈和元素栈需要保持同步，因为两个栈size并不相等
        int value = this.stackData.pop();
        if (value == this.getMin()) {
            this.stackMin.pop();
        }
        return value;
    }

    public int getMin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("your stack is empty!");
        }
        // 最小值栈中的栈顶始终是最小值
        return this.stackMin.peek();
    }
}
