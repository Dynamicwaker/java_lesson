package com.dynamic.algorithm.ch02;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/9/8.10:23
 */

public class TestAll {
    public static void main(String[] args){
        BubbleArray bubbleArray = new BubbleArray();
        bubbleArray.insert(21);
        bubbleArray.insert(35);
        bubbleArray.insert(46);
        bubbleArray.insert(58);
        bubbleArray.insert(19);
        bubbleArray.insert(200);
        bubbleArray.insert(3);
        bubbleArray.display();
        bubbleArray.bubbleSort();
        bubbleArray.display();

        SelArray selArray = new SelArray();
        selArray.insert(21);
        selArray.insert(65);
        selArray.insert(2);
        selArray.insert(54);
        selArray.insert(39);
        selArray.insert(78);
        selArray.insert(1);
        selArray.insert(29);
        selArray.display();
        selArray.selSort();
        selArray.display();

        InsertArray insertArray = new InsertArray();
        insertArray.insert(31);
        insertArray.insert(45);
        insertArray.insert(312);
        insertArray.insert(20);
        insertArray.insert(1);
        insertArray.insert(78);
        insertArray.insert(63);
        insertArray.display();
        insertArray.insertSort();
        insertArray.display();

        StudentArray studentArray = new StudentArray();
        Student student1 = new Student(218,"a张三","男",18);
        Student student2 = new Student(102,"c李四","女",24);
        Student student3 = new Student(315,"b王五","男",26);

        studentArray.insert(student1);
        studentArray.insert(student2);
        studentArray.insert(student3);

        studentArray.display();

        studentArray.selSortByNo();
        studentArray.display();

        studentArray.selSortByName();
        studentArray.display();
    }
}
