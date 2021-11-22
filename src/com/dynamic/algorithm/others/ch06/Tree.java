package com.dynamic.algorithm.others.ch06;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/9/14.0:01
 * @description
 */

public class Tree {
    /**
     * 根
      */
    private Node root;

    /**
     * 插入方法
     */
    public void insert(int keyData, int otherData) {
        Node newNode = new Node(keyData, otherData);

        // 如果说没有节点
        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (keyData < current.getKeyData()) {
                    current = current.getLeftNode();
                    if (current == null) {
                        parent.setLeftNode(newNode);
                        return;
                    }
                } else {
                    current = current.getRightNode();
                    if (current == null) {
                        parent.setRightNode(newNode);
                        return;
                    }
                }
            }
        }
    }

    /**
     *  查找方法
     */
    public Node find(int keyData) {
        Node current = root;
        while (current.getKeyData() != keyData) {
            if (keyData < current.getKeyData()) {
                current = current.getLeftNode();
            } else {
                current = current.getRightNode();
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    /**
     * 修改方法
     */
    public void change(int keyData, int newOtherData) {
        Node findNode = find(keyData);
        findNode.setOtherData(newOtherData);
    }

    /**
     * 先、中、后都是相对于根节点而言
     * 先序遍历，先访问父节点
     */
    public void preOrder(Node node) {
        if (node != null) {
            node.display();
            preOrder(node.getLeftNode());
            preOrder(node.getRightNode());
        }
    }

    /**
     * 中序遍历，先访问左子节点
     */
    public void medOrder(Node node) {
        if (node != null) {
            medOrder(node.getLeftNode());
            node.display();
            medOrder(node.getRightNode());
        }
    }

    /**
     * 后序遍历，先访问右子节点
     */
    public void endOrder(Node node) {
        if (node != null) {
            endOrder(node.getLeftNode());
            endOrder(node.getRightNode());
            node.display();
        }
    }

    public Node getRoot() {
        return root;
    }

}
