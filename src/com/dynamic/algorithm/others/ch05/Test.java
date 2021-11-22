package com.dynamic.algorithm.others.ch05;

import com.dynamic.algorithm.others.ch01.MyArray;

import java.util.Date;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/9/13.22:33
 * @description 构建时间的比较，构建慢的链表插入比顺序表快
 */

public class Test {
    public static void main(String[] args) {
        // 构建链表的时间的长度
        Date dateTemp = new Date();
        LinkList linkList = new LinkList();
        for (int i = 0; i < 10000000; i++) {
            linkList.insert(i);
        }
        Date dateEnd = new Date();
        System.out.println("构建链表数据用时：" + (dateEnd.getTime() - dateTemp.getTime()));

        // 构建顺序表
        dateTemp = new Date();
        MyArray array = new MyArray(10000000);
        for (int j = 0; j < 10000000; j++) {
            array.insert(j);
        }
        dateEnd = new Date();
        System.out.println("构建数组数据用时：" + (dateEnd.getTime() - dateTemp.getTime()));
    }
}
