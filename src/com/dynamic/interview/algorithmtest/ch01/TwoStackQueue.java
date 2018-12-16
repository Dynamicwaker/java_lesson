package com.dynamic.interview.algorithmtest.ch01;

import java.util.Stack;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/12/16.21:41
 * @description 编写一个类，使用两个栈实现队列，支持队列基本操作，（add,poll,peek）
 * 栈的原则先进后出，队列是先进先出，那则需要两个栈更好翻个顺序
 * 要求：stackPush倒的时候，stackPop必须是空的，而且必须一次性将stackPush中的数据导入到stackPop
 */

public class TwoStackQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public TwoStackQueue() {
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    /**
     * 推入的时候不做处理压入pop栈的操作
     */
    public void add(int pushInt) {
        stackPush.push(pushInt);
    }

    /**
     * 只在poll和peek时才压入pop栈，满足一次性在pop栈为空的情况下压入。
     * 因为只能这样才能保证顺序，不然pop顺序会乱掉
     */
    public int poll() {
        if (stackPush.empty() && stackPop.empty()) {
            throw new RuntimeException("Queue is empty!");
        } else if (stackPop.empty()) {
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    public int peek() {
        if (stackPush.empty() && stackPop.empty()) {
            throw new RuntimeException("queue is empty!");
        } else if (stackPop.empty()) {
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }
}
