package com.dynamic.algorithm.others.ch02;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/9/8.15:39
 * @description
 */

public class Student {
    /**
     * 学号
      */
    private int stuNo;
    /**
     * 姓名
      */
    private String stuName;
    /**
     * 性别
      */
    private String sex;
    /**
     * 年龄
      */
    private int age;

    public Student(int stuNo, String stuName, String sex, int age) {
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.sex = sex;
        this.age = age;
    }

    public int getStuNo() {
        return stuNo;
    }

    public void setStuNo(int stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void display() {
        System.out.println("学号：" + stuNo + "，姓名：" + stuName + "，性别：" + sex + "，年龄：" + age);
    }
}
