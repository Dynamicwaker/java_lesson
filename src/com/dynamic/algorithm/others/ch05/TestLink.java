package com.dynamic.algorithm.others.ch05;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/9/10.21:31
 * @description 测试链节点
 */

public class TestLink {
    public static void main(String[] args) {

        Link link1 = new Link(10);
        Link link2 = new Link(45);
        Link link3 = new Link(360);
        Link link4 = new Link(14);

        link1.setNext(link2);
        link2.setNext(link3);
        link3.setNext(link4);
        link4.setNext(link1);

        System.out.println(link1.getNext().getNext().getNext().getData());
        System.out.println(link1.getNext().getNext().getNext().getNext().getData());
        System.out.println("____________________________");

        LinkList linkList = new LinkList();
        linkList.insert(12);
        linkList.insert(5);
        linkList.insert(37);
        linkList.insert(81);

        linkList.displayAll();
        System.out.println();
        System.out.println(linkList.find(12).getData());
        // System.out.println(linkList.find(6).getData());

        linkList.insert(75, 2);
        linkList.displayAll();
        System.out.println();
        linkList.insert(69, 0);
        linkList.displayAll();
        System.out.println();
        linkList.delete(37);
        linkList.delete(81);
        linkList.displayAll();
    }

}
