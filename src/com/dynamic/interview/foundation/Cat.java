package com.dynamic.interview.foundation;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-12-09
 * @description 实例变量初始化：
 * 1、定义时指定初始值
 * 2、非静态初始化块中对实例变量赋值
 * 3、构造器中对实例变量指定
 */
public class Cat {
    String name;
    int age;

    /**
     * 构造函数初始化
    */
    public Cat(String name, int age) {
        System.out.println("执行构造器！");
        this.age = age;
        this.name = name;
    }

    {
        System.out.println("执行非静态初始化块！");
        weight = 2.0;
    }
    /**
     * 定义时初始化，定义和赋值是分开的两个操作，
     * 此时定义完之后先执行上面的初始化代码块的赋值操作再执行赋值操作，所以2.3会覆盖2.0
    */
    double weight = 2.3;

    @Override
    public String toString() {
        return "Cat{" + "name='" + name + '\'' + ", age=" + age + ", weight=" + weight + '}';
    }

    public static void main(String[] args) {
        Cat cat = new Cat("kitty", 2);
        System.out.println(cat);
        Cat cat1 = new Cat("jerry", 3);
        System.out.println(cat1);
    }
}
