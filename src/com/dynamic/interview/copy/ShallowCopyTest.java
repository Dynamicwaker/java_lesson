package com.dynamic.interview.copy;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/11/1.23:46
 * @description 浅拷贝
 */

public class ShallowCopyTest {
    public static void main(String args[]) {

        Student1 stu1 = new Student1();
        stu1.setNumber(12345);
        Student1 stu2 = (Student1) stu1.clone();

        System.out.println("学生1:" + stu1.getNumber());
        System.out.println("学生2:" + stu2.getNumber());

        stu2.setNumber(54321);

        System.out.println("学生1:" + stu1.getNumber());
        System.out.println("学生2:" + stu2.getNumber());
    }

}
