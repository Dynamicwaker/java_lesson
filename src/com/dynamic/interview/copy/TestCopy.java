package com.dynamic.interview.copy;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/11/1.23:38
 * @description 测试拷贝
 */

public class TestCopy {

    public static void main(String args[]) {

        Student stu1 = new Student();
        stu1.setNumber(12345);
        Student stu2 = stu1;

        System.out.println("学生1:" + stu1.getNumber());
        System.out.println("学生2:" + stu2.getNumber());

        stu2.setNumber(54321);

        System.out.println("学生1:" + stu1.getNumber());
        System.out.println("学生2:" + stu2.getNumber());

    }
}
