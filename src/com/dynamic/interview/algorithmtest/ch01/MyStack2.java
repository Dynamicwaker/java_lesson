package com.dynamic.interview.algorithmtest.ch01;

import java.util.Stack;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/12/16.21:11
 * @description 实现一个特殊的栈，在实现基本功能的基础上，返回栈中的最小元素的操作，解法2
 */

public class MyStack2 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack2() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(int newNum) {
        // 在确保最小值是栈顶元素的情况下，直接复制最小值的push到栈顶，保证两个栈的元素个数相同
        if (this.stackMin.isEmpty()) {
            this.stackMin.push(newNum);
        } else if (newNum < this.getMin()) {
            this.stackMin.push(newNum);
        } else {
            int newMin = this.stackMin.peek();
            this.stackMin.push(newMin);
        }
        // 元素栈不需要判断直接塞入
        this.stackData.push(newNum);

    }

    public int pop() {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("your stack is empty!");
        }
        /**
         * 因为始终两个栈的size是一致，只有两种情况（不可能出现最小栈栈顶的元素大于元素栈顶元素的情况）:
         * 1、元素栈顶元素就是最小值，此时最小栈元素最小，同时删除没有问题
         * 2、元素栈顶元素大于最小值，此时最小栈元素还是最小，而且，在一个元素是与它相等的元素，删除也没有问题
         */
        this.stackMin.pop();
        return this.stackData.pop();
    }

    public int getMin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("your stack is empty!");
        }
        // 最小值栈中的栈顶始终是最小值
        return this.stackMin.peek();
    }
}
