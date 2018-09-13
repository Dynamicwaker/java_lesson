package com.dynamic.algorithm.ch05;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/9/10.22:01
 * @description 实现链表
 */

public class LinkList {

    // 只包含头指针
    private Link first;

    // 插入节点，但是都是插入到头指针的位置
    public void insert(long value) {
        Link link = new Link(value);
        // 空的指针，直接将firit头指针指向link
        if (first == null) {
            first = link;
        } else {
            // 如果有数据，则把原来firit的指针域指向的位置赋给link的指针域指向的位置
            // 再把first指向link的链节点
            // 永远记住first是一个指针域，指向一个地址！！！
            link.setNext(first);
            first = link;
        }
    }

    // 展示数据
    public void displayAll() {
        Link current = first;
        while (current != null) {
            current.getData();
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
    }

    // 查找节点
    public Link find(long key) {
        Link current = first;
        while (current.getData() != key) {
            // 找不到就会报空指针异常
            if (current.getNext() == null) {
                return null;
            }
            current = current.getNext();

        }
        return current;
    }

    // 插入节点到指定位置
    public void insert(long value, int position) {
        if (position == 0) {
            insert(value);
        } else {
            Link current = first;
            for (int i = 0; i < position - 1; i++) {
                current = current.getNext();
            }
            Link link = new Link(value);
            link.setNext(current.getNext());
            current.setNext(link);
        }
    }

    public void delete(long key) {
        Link current = first;
        Link former = first;
        while (current.getData() != key) {
            if (current.getNext() != null) {
                former = current;
                current = current.getNext();
            } else {
                return;
            }
        }
        // 删除第一个节点
        if (current == first) {
            first = first.getNext();
        } else {
            former.setNext(current.getNext());
        }
    }


}
