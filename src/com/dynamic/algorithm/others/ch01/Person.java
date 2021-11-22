package com.dynamic.algorithm.others.ch01;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/9/6.22:14
 * @description
 */

public class Person {

    private String name;
    private int age;
    private String sex;

    public Person(String name, int age, String sex) {
        super();
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void display() {
        System.out.print("姓名:" + this.name);
        System.out.print("年龄:" + this.age);
        System.out.print("性别:" + this.sex + " ");
    }
}
