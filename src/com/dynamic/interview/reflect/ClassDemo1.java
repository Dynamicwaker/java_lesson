package com.dynamic.interview.reflect;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/9/23.17:19
 * @description 反射的概念
 */

public class ClassDemo1 {
    public static void main(String[] args) {
        // Foo的实例对象如何表示
        Foo foo1 = new Foo();
        // Foo这个类也是一个实例对象，Class类的实例对象，如何表示？有三种方式
        // 第一种方式，任何一个类都是class的实例对象，每个类有都有一个隐含的静态成员变量class
        Class c1 = Foo.class;
        // 第二种方式，已知该类的对象通过getClass方法
        Class c2 = foo1.getClass();

        /**
         * 官网c1，c2表示了Foo类的类类型
         * 万事万物皆是对象，类也是对象，是Class类的实例对象
         * 这个对象我们成为该类的类类型
         *
         * */

        // 不管c1，c2都代表了Foo类的类类型，一个类只能是Class类的一个实例对象
        System.out.println(c1 == c2);

        // 第三种表达方式
        Class c3 = null;
        try {
            /** 不仅表示了类的类类型，还代表了动态加载类,类的加载器
             * 区分编译和运行
             * 编译时刻加载类是静态加载类，运行时加载类是动态加载类
             * new创建对象是静态加载类，在编译时刻就需要加载所有的可能使用到的类
             * 通过动态加载类可以解决这个问题
             **/
            c3 = Class.forName("com.dynamic.interview.reflect.Foo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(c2 == c3);

        // 我们还可以通过类的类类型创建该类的对象，通过c1，c2，c3创建Foo的实例
        try {
            /**
             *  前提是该类有无参数的构造方法
             *  动态加载类的话，不知道你运行应该加载的是哪个类，所有这里的强制类型转换就具有不确定行
             *  此时需要定义一个规范(接口的意义)，让其都转换成某个接口的对象
             *  之后使用的类就不需要重新编译，只需要动态的增加其他实现该接口的类来扩展功能
             *  很多问题都可以通过增加一个抽象的中间层来实现解决
              */
            Foo foo = (Foo) c1.newInstance();
            foo.print();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }

    }

}

