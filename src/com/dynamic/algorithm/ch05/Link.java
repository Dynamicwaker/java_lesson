package com.dynamic.algorithm.ch05;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/9/10.21:29
 * @description 链节点
 */

public class Link {
    // 数据域
    private long data;
    // 指针域
    private Link next;

    public Link(long data) {
        this.data = data;
    }

    public long getData() {
        return data;
    }

    public void setData(long data) {
        this.data = data;
    }

    public Link getNext() {
        return next;
    }

    public void setNext(Link next) {
        this.next = next;
    }
}
