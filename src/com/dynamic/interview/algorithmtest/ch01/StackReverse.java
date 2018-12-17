package com.dynamic.interview.algorithmtest.ch01;

import java.util.Stack;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/12/17.22:34
 * @description 使用堆栈和递归实现栈中的元素逆序
 */

public class StackReverse {

    /**
     * 使用递归来返回栈底的元素，然后将其pop
     */
    public static int getAndRemoveLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        // 递归要设置一个停止的标志（基准情形），不然无限递归
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    public static void reverse(Stack<Integer> stack) {
        // 基准情形
        if (stack.isEmpty()) {
            return;
        }
        // 将栈中的元素从底向上依次取出，然后再压入栈中，实现逆序
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }
}
