package com.dynamic.interview.collection;

/**
 * @author xinghuajian
 * @description
 * @date 2019/10/22 14:17
 */
public class Student implements Comparable<Student> {

    String name;
    int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }


    @Override
    public int compareTo(Student o) {
        if (o.score < this.score) {
            return 1;
        } else if (o.score > this.score) {
            return -1;
        }
        return 0;
    }
}
