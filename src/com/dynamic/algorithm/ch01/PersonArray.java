package com.dynamic.algorithm.ch01;

public class PersonArray {

    private Person[] arr;

    private int elems;


    public PersonArray() {
        arr = new Person[50];
    }

    public PersonArray(int max) {
        arr = new Person[max];
    }

    // 插入数据
    public void insert(Person person) {
        arr[elems] = person;
        elems++;
    }

    // 展示数据
    public void display() {
        for (int i = 0; i < elems; i++) {
            arr[i].display();
        }
        System.out.println();
    }

    // 查找数据
    public int find(String name) {
        int i;
        for (i = 0; i < elems; i++) {
            if (name.equals(arr[i].getName())) {
                break;
            }
        }

        if (i == arr.length) {
            return -1;
        } else {
            return i;
        }
    }

    // 根据人删除
    public void delete(Person person) {

        if (find(person.getName()) == -1) {
            System.out.println("查无此人，删除失败！");
        } else {
            for (int i = find(person.getName()); i < elems; i++) {
                arr[i] = arr[i + 1];
            }
        }
        elems--;
    }

    // 根据人名删除
    public void delete(String name) {

        if (find(name) == -1) {
            System.out.println("查无此人，删除失败");
        } else {
            for (int i = find(name); i < elems; i++) {
                arr[i] = arr[i + 1];
            }
        }
        elems--;
    }

    // 更改人名
    public void change(Person oldPerson, Person newPerson) {
        if (find(oldPerson.getName()) == -1) {
            System.out.println("更改失败");
        } else {
            arr[find(oldPerson.getName())] = newPerson;
        }
    }
}
