package com.dynamic.algorithm.others.ch01;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/9/6.20:48
 * @description
 */

public class MyArray {

    // 数组
    private long[] arr;

    /**
     * 有效数据的大小
      */
    private int elems;

    /**
     * 默认构造方法
     */
    public MyArray() {
        arr = new long[50];
    }

    public MyArray(int max) {
        arr = new long[max];
    }

    /**
     * 插入数据
     * @param value
     */
    public void insert(long value) {
        arr[elems] = value;
        elems++;
    }

    /**
     * 显示数据
     */
    public void display() {
        for (int i = 0; i < elems; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * 查找数据
     * @param value
     * @return
     */
    public int find(long value) {
        int i;
        for (i = 0; i < elems; i++) {
            if (arr[i] == value) {
                break;
            }
        }

        if (i == elems) {
            return -1;
        } else {
            return i;
        }

    }

    /**
     * 删除操作
      */
    public void delete(long deleteKey) {

        if (find(deleteKey) == -1) {
            System.out.println("查找不到指定数据");
        } else {
            for (int i = find(deleteKey); i < elems; i++) {
                arr[i] = arr[i + 1];
            }
        }

    }


    /**
     * 修改数
     */
    public void modify(long former_value, long newValue) {
        if (find(former_value) == -1) {
            System.out.println("查找不到指定数据，修改失败！");
        } else {
            arr[find(former_value)] = newValue;
        }
    }


}
