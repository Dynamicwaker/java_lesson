package com.dynamic.algorithm.others.ch02;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/9/8.15:43
 * @description 按照对象属性排序
 */

public class StudentArray {

    /**
     * 数组
     */
    private Student[] arr;

    /**
     * 有效数据的大小
      */
    private int elems;

    /**
     * 默认构造方法
     */
    public StudentArray() {
        arr = new Student[50];
    }

    public StudentArray(int max) {
        arr = new Student[max];
    }

    /**
     * 插入数据
      */
    public void insert(Student student) {
        arr[elems] = student;
        elems++;
    }

    /**
     * 显示数据
      */
    public void display() {
        for (int i = 0; i < elems; i++) {
            arr[i].display();
        }
        System.out.println();
    }

    /**
     * 选择排序
      */
    public void selSortByNo() {
        // 经过n-1次操作后，最后一个操作不用执行最后也是最大的了
        Student temp = null;
        int min = 0;
        for (int i = 0; i < elems - 1; i++) {
            min = i;
            for (int j = i; j < elems; j++) {
                if (arr[min].getStuNo() > arr[j].getStuNo()) {
                    min = j;
                }
            }
            temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    public void selSortByName() {

        Student temp = null;
        int min = 0;
        for (int i = 0; i < elems - 1; i++) {
            min = i;
            for (int j = i; j < elems; j++) {
                if (arr[min].getStuName().compareTo(arr[j].getStuName()) > 0) {
                    min = j;
                }
            }
            temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
}
