package com.dynamic.algorithm.ch06;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/9/16.21:20
 * @description
 */

public class TestTree {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(1, 1);
        tree.insert(2, 41);
        tree.insert(3, 3);

        Node foundNode = tree.find(2);
        foundNode.display();

        Tree treeTemp = new Tree();
        treeTemp.insert(80, 80);
        treeTemp.insert(49, 49);
        treeTemp.insert(42, 42);
        treeTemp.insert(30, 30);
        treeTemp.insert(45, 45);
        treeTemp.insert(90, 90);
        treeTemp.insert(150, 150);
        treeTemp.insert(130, 130);
        treeTemp.insert(82, 82);
        treeTemp.insert(91, 91);
        System.out.println("--------------先序遍历--------------");
        treeTemp.preOrder(treeTemp.getRoot());
        System.out.println("--------------中序遍历--------------");
        treeTemp.medOrder(treeTemp.getRoot());
        System.out.println("--------------后序遍历--------------");
        treeTemp.endOrder(treeTemp.getRoot());
    }
}
