package com.dynamic.interview.copy;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/11/1.23:51
 * @description
 */

public class Student2 implements Cloneable {
    private int number;

    private Address addr;

    public Address getAddr() {
        return addr;
    }

    public void setAddr(Address addr) {
        this.addr = addr;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public Object clone() {
        Student2 stu = null;
        try {
            // 浅复制
            stu = (Student2) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        // 深度复制
        stu.addr = (Address) addr.clone();
        return stu;
    }

}
