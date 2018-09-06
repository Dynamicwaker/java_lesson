package com.dynamic.algorithm.ch01;

public class TestPersonArray {

    public static void main(String[] args) {
        PersonArray pa = new PersonArray();

        // 创建人员
        Person p1 = new Person("张三", 20, "女");
        Person p2 = new Person("李四", 21, "女");
        Person p3 = new Person("王五", 22, "男");
        Person p4 = new Person("菜鸡", 23, "男");
        Person p5 = new Person("贱人˹", 24, "女");

        // 插入人员
        pa.insert(p1);
        pa.insert(p2);
        pa.insert(p3);
        pa.insert(p4);
        pa.insert(p5);

        pa.display();

        // 删除
        pa.delete(p4);
        pa.display();

        pa.delete("李四");
        pa.display();

        //修改
        Person newPerson = new Person("贱人", 40, "男");
        pa.change(p1, newPerson);
        pa.display();
    }

}
