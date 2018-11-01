package com.dynamic.interview.copy;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/11/1.23:52
 * @description 深度拷贝
 */

public class DeepCopyTest {
    public static void main(String args[]) {

        Address addr = new Address();
        addr.setAdd("杭州市");
        Student2 stu2 = new Student2();
        stu2.setNumber(123);
        stu2.setAddr(addr);

        Student2 stu3 = (Student2) stu2.clone();

        System.out.println("学生1:" + stu2.getNumber() + ",地址:" + stu2.getAddr().getAdd());
        System.out.println("学生2:" + stu3.getNumber() + ",地址:" + stu3.getAddr().getAdd());

        addr.setAdd("西湖区");

        System.out.println("学生1:" + stu2.getNumber() + ",地址:" + stu2.getAddr().getAdd());
        System.out.println("学生2:" + stu3.getNumber() + ",地址:" + stu3.getAddr().getAdd());
    }

}
