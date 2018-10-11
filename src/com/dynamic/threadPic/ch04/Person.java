package com.dynamic.threadPic.ch04;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-10-11
 * @description 使用Immutable模式 不可变性，实例一旦创建字段值就不再改变
 */
public final class Person {
    private final String name;
    private final String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "[ Person name = " + name + ",address = " + address + " ]";
    }
}
